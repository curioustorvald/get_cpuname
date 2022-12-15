A simple set of commands to get CPU's name (e.g. Intel (R) Core(TM) i7-6700K ...) and manufacturer (e.g. GenuineIntel), in Java.

### Methods
- ```GetCpuName.getModelName()```
    + returns name of the processor installed in String
- ```GetCpuName.getCPUID()```
    + returns processor's manufacturer (or CPUID) in String

### Dependency
- Windows: Vista or later to run `wmic`

### Limitations
- ARM processors: `getCPUID()` will not work

### License

- MIT

### Examples

x86-64 Processors:

```
WINDOWS 10
>>>Intel(R) Core(TM) i7-6700K CPU @ 4.00GHz<<<
>>>GenuineIntel<<<
```

```
WINDOWS 10
>>>AMD FX(tm)-8300 Eight-Core Processor<<<
>>>AuthenticAMD<<<
```

```
LINUX
>>>AMD Ryzen 9 7950X 16-Core Processor<<<
>>>AuthenticAMD<<<
```

```
MAC OS X
>>>Intel(R) Core(TM) i5-3210M CPU @ 2.50GHz<<<
>>>GenuineIntel<<<
```

Raspberry PI:

```
LINUX
>>>ARMv7 Processor rev 4 (v7l)<<<
>>>null<<<
```
