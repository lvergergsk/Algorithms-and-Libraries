package lvergergsk.examples.rxkotlin

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit


class ObservableExample {
    @Test
    fun basicExample01() {
        var result = ""
        val observable = Observable.just("Hello") // provides data
        observable.subscribe { s -> result = s } // Callable as subscriber
        Assertions.assertTrue(result.equals("Hello"))
    }

    @Test
    fun basicEsample02() {
        var result = ""
        val letters = arrayOf("a", "b", "c", "d", "e", "f", "g")
        val observable: Observable<String> = Observable.fromArray(*letters)
                .map(String::toUpperCase)
        observable.subscribe({ i -> result += i },
                Throwable::printStackTrace,
                { result += "_Completed" })

        Assertions.assertEquals("ABCDEFG_Completed", result);
    }

    data class Book(val title: String, val id: Int)

    @Test
    fun flatMapExample() {
        var result = ""
        val books = arrayOf(Book("Book 1", 1), Book("Book 2", 2))
        val observable: Observable<String> = Observable.fromArray(*books)
                .flatMap { t -> Observable.just(t.title) }
        observable.subscribe { t -> result += "{$t} " }

        Assertions.assertEquals("{Book 1} {Book 2} ", result);
    }

    @Test
    fun scanExample() {
        var result = ""

        val letters = arrayOf("a", "b", "c")
        Observable.fromArray(*letters)
                .scan(StringBuilder(), StringBuilder::append)
                .subscribe { total -> result += total.toString() }
        Assertions.assertEquals("aababc", result)
    }

    @Test
    fun groupByExample() {
        val even = mutableListOf<Int>()
        val odd = mutableListOf<Int>()

        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Observable.fromArray(*numbers)
                .groupBy { i -> if (0 == i % 2) "EVEN" else "ODD" }
                .subscribe { group ->
                    group.subscribe { number ->
                        if (group.key.toString() == "EVEN") {
                            even.add(number)
                        } else {
                            odd.add(number)
                        }
                    }
                }
        Assertions.assertEquals(listOf(1, 3, 5, 7, 9), odd)
        Assertions.assertEquals(listOf(2, 4, 6, 8, 10), even)
    }

    @Test
    fun filterExample() {
        val result = mutableListOf<Int>()

        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Observable.fromArray(*numbers)
                .filter { i -> i % 2 == 0 } // If true, pass. If false, filtered.
                .subscribe { i -> result.add(i) }

        Assertions.assertEquals(listOf(2, 4, 6, 8, 10), result)
    }

    @Test
    fun defaultIfEmptyExample() {
        var result = ""

        Observable.empty<String>()
                .defaultIfEmpty("Observable is empty")
                .subscribe { s -> result += s }

        Assertions.assertEquals("Observable is empty", result)
    }

    @Test
    fun firstExample() {
        var result = ""

        val numbers = arrayOf(1, 2, 3)

        var observable = Observable.fromArray(*numbers)
                .first(-1)
        observable.subscribe { i -> result += i }

        Assertions.assertEquals("1", result)
    }

    @Test
    fun takeWhileExample() {
        var sum = 0
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//        s -> sum += s
        val observer = object : Observer<Int> {
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onNext(t: Int) {
                sum += t
            }

            override fun onComplete() {
                println("Subscriber completed")
            }

            override fun onSubscribe(d: Disposable) {
                println("Subscriber Subscribed.")
            }
        }

        Observable.fromArray(*numbers)
                .takeWhile { i -> i < 5 }
                .subscribe(observer)

        Assertions.assertEquals(10, sum)
    }

    @Test
    fun connectableObservableExample() {
        val result = mutableListOf<Long>()
        val connectable = Observable.interval(200, TimeUnit.MILLISECONDS).publish()
        connectable.subscribe { i -> result.add(i) }

        Assertions.assertEquals(0, result.size)

        connectable.connect()
        Thread.sleep(700)

        Assertions.assertEquals(listOf(0L, 1L, 2L), result)
    }

    @Test
    fun singleExample() {
        var result = ""
        val single = Single.just("Hello")
                .doOnSuccess { i -> result += i }
                .doOnError { error -> throw RuntimeException(error.message) }
        single.subscribe()

        Assertions.assertEquals("Hello", result)
    }

    @Test
    fun usingExample() {
        var result = ""
        val values = Observable.using(
                { "MyResource" },
                { r ->
                    Observable.create { o: ObservableEmitter<Char> ->
                        for (c in r.toCharArray()) {
                            o.onNext(c)
                        }
                        o.onComplete()
                    }
                },
                { r -> println("Disposed: $r") }
        )
        values.subscribe(
                { v -> result += v },
                { e -> result += e }
        )
        Assertions.assertEquals("MyResource", result)
    }
}
