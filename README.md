Weld Core MicroBenchmarks
=========================

By default, benchmarks are run for 5.1.1.SP2.
use `-v` to run the benchmarks for a specific set of Weld versions:

```
$ ./run-benchmarks.sh -v "5.1.1.Final 5.1.1.SP2"
```

By default, all benchmarks are run.
Use `-b` to run a specific benchmark:

```
$ ./run-benchmarks.sh -b InterceptorBenchmark
```

By default, an HTML report and chart images are generated in `target/report` directory.
To specify a custom directory use `-o`:

```
$ ./run-benchmarks.sh -o /home/foo/bar
```

By default, `mvn` command is used to build the benchmarks shaded jar.
To specify a custom command use `-m`:

```
$ ./run-benchmarks.sh -m "/opt/maven/bin/mvn"
```

By default, no extra JVM options are set.
To specify JVM options use `-j`:

```
$ ./run-benchmarks.sh -j "-Dorg.jboss.weld.xml.disableValidating=true"
```