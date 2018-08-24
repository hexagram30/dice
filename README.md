# hexagram30/dice

*An entropy manager, random number generator/seed tracker, and dice-roller for hexagram30 projects*

[![][logo]][logo-large]


## About

The dice app defines a `random` system component which is designed for use by
all hexagram30 applications for its random number generation. The `random`
component does not use Clojure's default support for random (i.e.,
`java.util.Random`), but rather `java.security.SecureRandom` and as such is
suitable for use in powering in-game economic computations.


## Usage

### From the command line

In order to use the roller from the command line, you'll need to build it"

```
$ lein build-cli
```

The reason that a build step is necessary is that the CLI tool is written in
ClojureScript to avoid long startup times of the JVM. To accomplish this,
`./bin/roll` acts as a UDP client that connects to hexagram30/dice's UDP
service.

Using the newly-built CLI tool, you may specify as many (or as few) die
type and die number that you want to roll simultaneously:

```
$ ./bin/roll d10 2 d20 5 d4 6 d8 2 d10 2 d10 4 d100 1 d12 3
```
```
 __                                                 ______ ______
|  |--.-----.--.--.---.-.-----.----.---.-.--------.|__    |      |
|     |  -__|_   _|  _  |  _  |   _|  _  |        ||__    |  --  |
|__|__|_____|__.__|___._|___  |__| |___._|__|__|__||______|______|

........................................  d i c e  ...............


d10:
    39 15 [9 8 5 5 :sum 27]
d20:
    [13 5 3 19 14 :sum 54]
d4:
    [4 2 3 4 2 4 :sum 19]
d8:
    [5 8 :sum 13]
d100:
    84
d12:
    [9 4 2 :sum 15]

```

Note that the results are grouped by dice type, with results given in the order
first seen.


If, for whatever reason, you want to use the JVM with the CLI, you can do so
with the `lein` alias:

```
$ lein roll d10 2 d20 5 d4 6 d8 2 d10 2 d10 4 d100 1 d12 3
```


### From the REPL

First, we need to start the system:
```clj
[hxgm30.dice.repl] λ=> (startup)
```

With the standard output of:
```
2018-08-22T21:45:49.813 [nREPL-worker-0] INFO hxgm30.dice.components.config:55 - Starting config component ...
2018-08-22T21:45:49.870 [nREPL-worker-0] INFO hxgm30.dice.components.logging:22 - Starting logging component ...
2018-08-22T21:45:49.874 [nREPL-worker-0] INFO hxgm30.dice.components.random:63 - Starting random component ...
2018-08-22T21:45:49.877 [nREPL-worker-0] INFO hxgm30.dice.components.udp:28 - Starting dice UDP CLI server component on port 2493...
:running

```

Now we can use the system-based `random` API:

```clj
[hxgm30.dice.repl] λ=> (random/int (system))
26506698
[hxgm30.dice.repl] λ=> (random/int (system) 100)
97
[hxgm30.dice.repl] λ=> (random/float (system))
0.59698063
[hxgm30.dice.repl] λ=> (random/double (system))
0.2833395304088826
[hxgm30.dice.repl] λ=> (random/long (system))
5481343508301620380
[hxgm30.dice.repl] λ=> (random/bigint (system))
-6431860707905474045N
[hxgm30.dice.repl] λ=> (random/bigdec (system))
0.6297262833005943M
[hxgm30.dice.repl] λ=> (random/nth (system) [:alice :bob :carol :dave :eve :fred])
:fred
```

And the `dice` API:

```clj
[hxgm30.dice.repl] λ=> (dice/d4 (system))
2
[hxgm30.dice.repl] λ=> (dice/d6 (system))
5
[hxgm30.dice.repl] λ=> (dice/d8 (system))
7
[hxgm30.dice.repl] λ=> (dice/d10 (system))
9
[hxgm30.dice.repl] λ=> (dice/d12 (system))
12
[hxgm30.dice.repl] λ=> (dice/d20 (system))
17
[hxgm30.dice.repl] λ=> (dice/d100 (system))
74
```

You can also make multiple roles:

```clj
[hxgm30.dice.repl] λ=> (dice/d6 (system) 3)
[6 3 5]
[hxgm30.dice.repl] λ=> (dice/d20 (system) 4)
[3 6 12 5]
```

Note that d10 has a special case: if you roll two, the value is interpretted as
a value between 1 and 100 (inclusive). However, it doesn't do this by calling
d100; it really rolls two d10 and assembles the resulting values:

```clj
[hxgm30.dice.repl] λ=> (dice/d10 (system) 2)
67
```

Finally, there is a `roll` function where you can specity the types and number
of die:

```clj
[hxgm30.dice.repl] λ=> (dice/roll (system) {:d4 3 :d6 2 :d8 4 :d10 2 :d12 5 :d20 6})
[[1 3 3] [6 5] [2 7 6 8] [5 8] [6 3 6 8 2] [1 1 5 9 7 14]]
```

If you would like to add the results of multi-die rolls, you can do that too:

```clj
[hxgm30.dice.repl] λ=> (dice/sum (dice/d20 (system) 4))
35
[hxgm30.dice.repl] λ=> (dice/sum (dice/roll (system) {:d4 1 :d6 2 :d8 3 :d10 4 :d20 5}))
126
```


## Donating

A donation account for supporting development on this project has been set up
on Liberapay here:

* [https://liberapay.com/hexagram30/donate](https://liberapay.com/hexagram30/donate)

You can learn more about Liberapay on its [Wikipedia entry][libera-wiki] or on the
service's ["About" page][libera-about].

[libera-wiki]: https://en.wikipedia.org/wiki/Liberapay
[libera-about]: https://liberapay.com/about/


## License

```
Copyright © 2018, Hexagram30 <hexagram30@cnbb.games>

Apache License, Version 2.0
```

<!-- Named page links below: /-->

[logo]: https://raw.githubusercontent.com/hexagram30/resources/master/branding/logo/h30-logo-2-long-with-text-x695.png
[logo-large]: https://raw.githubusercontent.com/hexagram30/resources/master/branding/logo/h30-logo-2-long-with-text-x3440.png
[comp-event]: https://github.com/hexagram30/hexagramMUSH/blob/master/src/hexagram30/mush/components/event.clj
