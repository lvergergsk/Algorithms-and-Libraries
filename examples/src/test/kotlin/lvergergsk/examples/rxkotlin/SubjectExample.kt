package lvergergsk.examples.rxkotlin

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import lvergergsk.examples.util.Utils.loggerFor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


// A Subject is simultaneously two elements, a subscriber and an observable.
class SubjectExample {

    private val log = loggerFor(javaClass)

    var subscriber1: Int = 0
    var subscriber2: Int = 0
    fun getFirstObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onNext(t: Int) {
                log.debug("Subscriber1 received val: {}.", t)
                subscriber1 += t
            }

            override fun onComplete() {
                log.debug("Subscriber1 completed")
            }

            override fun onSubscribe(d: Disposable) {
                log.debug("Subscriber1 Subscribed.")
            }
        }
    }

    fun getSecondObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onNext(t: Int) {
                log.debug("Subscriber2 received val: {}.", t)
                subscriber2 += t
            }

            override fun onComplete() {
                log.debug("Subscriber2 completed")
            }

            override fun onSubscribe(d: Disposable) {
                log.debug("Subscriber2 Subscribed.")
            }
        }
    }

    @BeforeEach
    fun beforeEach() {
        subscriber1 = 0
        subscriber2 = 0
    }

    /**
     * An AsyncSubject emits the last value (and only the last value) emitted by the source Observable,
     * and only after that source Observable completes.
     */
    @Test
    fun asyncSubjectExample() {
        val asyncSubject: AsyncSubject<Int> = AsyncSubject.create()
        asyncSubject.subscribe(getFirstObserver())
        asyncSubject.onNext(1)
        asyncSubject.onNext(2)
        asyncSubject.subscribe(getSecondObserver())
        asyncSubject.onNext(3)
        asyncSubject.onNext(4)

        Assertions.assertEquals(0, subscriber1)
        Assertions.assertEquals(0, subscriber2)

        asyncSubject.onComplete()

        // This is not emitted.
        asyncSubject.onNext(5)

        Assertions.assertEquals(4, subscriber1)
        Assertions.assertEquals(4, subscriber2)
    }

    @Test
    fun behaviorSubjectExample() {
        val behaviorSubject: BehaviorSubject<Int> = BehaviorSubject.create()
        behaviorSubject.subscribe(getFirstObserver())

        behaviorSubject.onNext(1)
        behaviorSubject.onNext(2)
        behaviorSubject.subscribe(getSecondObserver())
        behaviorSubject.onNext(3)
        behaviorSubject.onNext(4)

        behaviorSubject.onComplete()

        Assertions.assertEquals(10, subscriber1)
        Assertions.assertEquals(9, subscriber2)
    }


    @Test
    fun publishSubjectExample() {
        val publishSubject: PublishSubject<Int> = PublishSubject.create()
        publishSubject.subscribe(getFirstObserver())
        publishSubject.onNext(1)
        publishSubject.onNext(2)
        publishSubject.onNext(3)
        publishSubject.subscribe(getSecondObserver())
        publishSubject.onNext(4)
        publishSubject.onComplete()

        // This is not emitted.
        publishSubject.onNext(5)

        Assertions.assertEquals(10, subscriber1)
        Assertions.assertEquals(4, subscriber2)
    }

    @Test
    fun ReplaySubjectExample() {
        val replaySubject: ReplaySubject<Int> = ReplaySubject.createWithSize(5)
        replaySubject.subscribe(getFirstObserver())
        replaySubject.onNext(1)
        replaySubject.onNext(2)
        replaySubject.onNext(3)
        replaySubject.onNext(4)
        replaySubject.onNext(5)
        replaySubject.onNext(6)
        replaySubject.onNext(7)
        replaySubject.onNext(8)
        replaySubject.subscribe(getSecondObserver())
        replaySubject.onNext(9)
        replaySubject.onNext(10)
        replaySubject.onComplete()

        // This is not emitted.
        replaySubject.onNext(11)

        Assertions.assertEquals(55, subscriber1)
        Assertions.assertEquals(49, subscriber2)
    }
}
