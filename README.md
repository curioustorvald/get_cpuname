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

EM-EYE-TEE mf
