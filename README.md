# hexagram30/dice

*An entropy manager, random number generator/seed tracker, and dice-roller for hexagram30 projects*

[![][logo]][logo-large]


## Usage

### From the command line

```
TBD
```

### From the REPL

First, we need to start the system:
```
[hxgm30.dice.repl] λ=> (startup)
```

With the standard output of:
```
2018-08-22T11:41:52.629 [nREPL-worker-50] INFO hxgm30.dice.components.config:51 - Starting config component ...
2018-08-22T11:41:52.629 [nREPL-worker-50] DEBUG hxgm30.dice.components.config:52 - Using configuration: {:rng {:algorithm :non-blocking, :seed-bytes 1024}, :logging {:level :debug, :nss [hxgm30]}}
2018-08-22T11:41:52.630 [nREPL-worker-50] DEBUG hxgm30.dice.components.config:53 - Started config component.
2018-08-22T11:41:52.630 [nREPL-worker-50] INFO hxgm30.dice.components.logging:22 - Starting logging component ...
2018-08-22T11:41:52.630 [nREPL-worker-50] DEBUG hxgm30.dice.components.logging:25 - Setting up logging with level :debug
2018-08-22T11:41:52.630 [nREPL-worker-50] DEBUG hxgm30.dice.components.logging:26 - Logging namespaces: [hxgm30]
2018-08-22T11:41:52.631 [nREPL-worker-50] DEBUG hxgm30.dice.components.logging:28 - Started logging component.
2018-08-22T11:41:52.631 [nREPL-worker-50] INFO hxgm30.dice.components.random:65 - Starting random component ...
2018-08-22T11:41:52.631 [nREPL-worker-50] DEBUG hxgm30.dice.components.random:66 - Started random component.
:running
```

Now we can use the system-based API:

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
