A simple set of commands to get CPU's name (e.g. Intel (R) Core(TM) i7-6700K ...) and manufacturer (e.g. GenuineIntel), in Java.

### Methods
- ```GetCpuName.getModelName()```
    + returns name of the processor installed in String
- ```GetCpuName.getCPUID()```
    + returns processor's manufacturer (or CPUID) in String

### Dependency
- Windows: Vista or later to run `wmic`

### Limitations
- ARM processors: getCPUID() will fail.

### License

- EM-EYE-TEE mf

### Examples

My computers:

```
WINDOWS 10
>>>Intel(R) Core(TM) i7-6700K CPU @ 4.00GHz<<<
>>>GenuineIntel<<<
```

```
MAC OS X
>>>Intel(R) Core(TM) i5-3210M CPU @ 2.50GHz<<<
>>>GenuineIntel<<<
```

From a friend of mine:

```
WINDOWS 10
>>>AMD FX(tm)-8300 Eight-Core Processor<<<
>>>AuthenticAMD<<<
```

Raspberry PI:

```
LINUX
>>>ARMv7 Processor rev 4 (v7l)<<<
>>>null<<<
```
