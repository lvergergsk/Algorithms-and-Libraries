[あなたのコードがどのように動作するのか、簡潔に説明してください。]
[Write a brief explanation about how your code works here.]

## 概要
こういう問題はTraceBackと言うアルゴリズムのファミリーで解けます。
TraceBackはRecursionを使う方法があるが、Recursionは回避した方がいいです。
その理由はRecursionが深くなるとStack Overflowになります。
（Tail Recursionではない方は特に忌むべきです）。

なのでこの問題では私はスタックを使ったDFSでときました。
問題の性質上パフォーマンスがよくないが、多項式時間でとけます。
（ちなみにDEV_MODEをfalseにして(7,7)で限界です）

## アルゴリズムについて：
まず最初にソースコードのなかのDEV_MODEをtrueにして、実行してみたらすごくわかりやすいと思います。
アルゴリズムの中で記録用にstackとtraceとvisited変数があります。
実際にDEV_MODEをtrueにして(2,3)実行してみたら下のようなoutputが出ます：
```
Current Stack: (0, 0)
Popped. Current Position = 0
Current Stack: (1, 3) (1, 1)
Popped. Current Position = 1
Current Stack: (1, 3) (2, 4) (2, 2)
Popped. Current Position = 2
Current Stack: (1, 3) (2, 4) (3, 5)
Popped. Current Position = 5
Current Stack: (1, 3) (2, 4) (4, 4)
Popped. Current Position = 4
Current Stack: (1, 3) (2, 4) (5, 3)
Popped. Current Position = 3
Trace: 0 1 2 5 4 3
-------------------
Current Stack: (1, 3) (2, 4)
Popped. Current Position = 4
Shortcut!!
Current Stack: (1, 3)
Popped. Current Position = 3
Current Stack: (2, 4)
Popped. Current Position = 4
Current Stack: (3, 1) (3, 5)
Popped. Current Position = 5
Current Stack: (3, 1) (4, 2)
Popped. Current Position = 2
Current Stack: (3, 1) (5, 1)
Popped. Current Position = 1
Trace: 0 3 4 5 2 1
-------------------
Current Stack: (3, 1)
Popped. Current Position = 1
Current Stack: (4, 2)
Popped. Current Position = 2
Current Stack: (5, 5)
Popped. Current Position = 5
Trace: 0 3 4 1 2 5
-------------------
3
```

最後の３は答えです。

- Stack変数について：
見たとおりノードXにいるときはXから次にいけるノードとそのノードで何歩めかをstackに入れます。
次ぎにいけるとこがない場合は、現時点POPされたノードまで戻します。
ノードの記録は、例えば(3,3)でしたら1行め1列めは0、2行め3列目は6。
例えば2歩めでいけるノードは３、４でしたらスタックに(2,3),(2,4)をいれます。

- Trace変数について：
Traceは経路を記録します。
主に突き詰まった時で戻すときにどのノードをVisitedからNot visitedにもどすかを判断するのに使います。

- Visited変数について：
これは単にどのノードが既に経過したことがあるのかを記録します。
”交差しない”ということは二つのノードがDegree１、ほかはすべてDegree２であること。
直感的に言えば一つのノードは一度しか踏まないことです。
なのですでにVisitedされたノードはいけることができません。

## 難しい点、工夫し他点：
- 難しい点似ついてはやはりパフォーマンスです。多項式時間では使えるものにはなりません。
テストケースはPassできますが、それで満足するではエンジニアとして何かが足りません。

- なので工夫した点として、同じ多項式時間ですが、少しだけ最適化してみました。
上の出力のなかで`Shortcut!!`がありました。
ショートカットの判断条件はもし現時点で左と右、あるいは上と下しかいけない場合、
現時点おルートではすべての点をカバーできませんので、つつける必要はありません。
なぜならtraceは連続的で左右、あるいは上下しかいけない場合は一つのループが作られたときだけです。
ループが作られたら、中から外、あるいは外から中にいくにはトポロジー的に"交差”しないといけません。
れいとしては：
```
12X
X3X
```
あるいは
```
1234
X9X5
X876
```

- これ以上に最適化したい場合似ついて考えます。
まず私のアルゴリズムはすべてのTraceを探し出して、それを数えます。
Traceを探して出して数えるならば私のアルゴリズムは一番いい複雑度クラスに入ります。
なぜなら実際の答えの数も多項式時間敵に増えます。
それに無駄の部分はすでにショートカットでカットされています。
もしも私のコードより早い複雑度クラスのアルゴリズムがある場合、
それは何かの計算式を未ちび出してAnalytical的なアプローチをとったアルゴリズムではないでしょうか。
Simulaticalのアルゴリズムでこれ以上最適化されるのは考えにくいです。

- もう一つの工夫した点として、私は普段からDEV_MODEをよく使います。
これはコードを読む人にとっての心遣いと考えています。
DEV_MODEをtrueにして実行すると、アルゴリズムを理解するために有利なoutputを書き出されます。
falseにしたらJITコンパイラが自動的に最適化するので、パフォーマンスに影響なゼロです。
