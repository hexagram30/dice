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

In order to use the roller from the command line, you'll need use the `hxgm30`
command-line interface tool. That is actually a [separate project][hxgm30-cli],
but we'll go over the dice-roll specifics here :-)

For installation or build of the `hxgm30` CLI tool, see the project page linked
above, but here are some usage examles:

```
$ ./bin/hxgm30 roll d10 2 d20 5 d4 6 d8 2 d10 2 d10 4 d100 1 d12 3
```
```
d10:
    39 15 [9 8 5 5]
d20:
    [13 5 3 19 14]
d4:
    [4 2 3 4 2 4]
d8:
    [5 8]
d100:
    84
d12:
    [9 4 2]

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
2020-01-01T02:13:18.902 [nREPL-worker-0] INFO hxgm30.dice.components.config:61 - Starting config component ...
2020-01-01T02:13:18.970 [nREPL-worker-0] INFO hxgm30.dice.components.logging:22 - Starting logging component ...
2020-01-01T02:13:18.974 [nREPL-worker-0] INFO hxgm30.dice.components.random:71 - Starting random component ...
2020-01-01T02:13:19.261 [nREPL-worker-0] INFO hxgm30.dice.components.grpcd:51 - Starting dice gRPC server component on port 2344...
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

And the `dice` (`hxgm30.dice.core`) API:

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
[2 1 2]
[hxgm30.dice.repl] λ=> (dice/d20 (system) 4)
[7 19 16 13]
```


Note that d10 has a special case: if you roll two, the value is interpretted as
a value between 1 and 100 (inclusive). However, it doesn't do this by calling
d100; it really rolls two d10 and assembles the resulting values:

```clj
[hxgm30.dice.repl] λ=> (dice/d10 (system) 2)
67
```

Finally, there is a `roll` function where you can specify the types and number
of die, just like with the command line tool:

```clj
[hxgm30.dice.repl] λ=> (dice/roll (system) :d10 2 :d20 5 :d4 6 :d8 2 :d10 2 :d10 4 :d100 1 :d12 3)

Results:

d10:
    47 24 [9 6 9 7]
d20:
    [8 9 16 8 7]
d4:
    [4 2 3 4 1 1]
d8:
    [4 5]
d100:
    78
d12:
    [10 11 6]


:ok
```

The results are presented in the same order as they are entered.

Note that this API is a wrapper for the more data-oriented `hxgm30.dice.roller`
API. The differences are most obvious when doing multiple rolls at
once:

```clj
(roller/roll (system) {:d10 2 :d20 5 :d4 6 :d8 2 :d100 1 :d12 3})
[47 [9 2 2 5 3] [2 3 4 2 1 3] [1 1] 81 [9 8 9]]
```

Some functions are only available in the `roller` API ...

For larger roll counts, the `stats` function maybe be useful:

```clj
[hxgm30.dice.repl] λ=> (def rs (dice/d6 (system) 10))
[hxgm30.dice.repl] λ=> rs
[2 6 5 3 6 1 5 2 5 6]
[hxgm30.dice.repl] λ=> (dice/stats rs)
{:avg 4.1 :high 6 :low 1 :sum 41}
```

The stats may also be returned when doing multiple roles with the
`metaroll` function:
```clj
[hxgm30.dice.repl] λ=> (roller/metaroll (system) {:d4 20 :d6 12 :d8 18 :d20 1})
[{:rolls [1 1 1 2 2 1 3 2 2 2 3 4 2 3 4 2 3 4 2 4]
  :stats {:avg 2.4 :high 4 :low 1 :sum 48}}
 {:rolls [1 5 3 6 4 2 1 5 5 2 5 1]
  :stats {:avg 3.3333333 :high 6 :low 1 :sum 40}}
 {:rolls [3 2 5 6 6 1 8 2 6 7 5 7 7 3 7 5 7 8]
  :stats {:avg 5.2777777 :high 8 :low 1 :sum 95}}
 {:roll 8}]
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
[hxgm30-cli]: https://github.com/hexagram30/cli
