Weld Core MicroBenchmarks
=========================

By default, benchmarks are run for 2.2.16.SP1 2.3.5.Final 2.4.6.Final and 3.0.2.Final.
use `-v` to run the benchmarks for a specific set of Weld versions:

```
$ ./run-benchmarks -v "2.4.6.Final 3.0.2.Final"
```

By default, all benchmarks are run.
Use `-b` to run a specific benchmark:

```
$ ./run-benchmarks -b InterceptorBenchmark
```

By default, an HTML report and chart images are generated in `target/report` directory.
To specify a custom directory use `-o`:

```
$ ./run-benchmarks -o /home/foo/bar
```