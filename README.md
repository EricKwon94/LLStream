# LLStream
This stream API can use under API level 24
# Setup
```java
repositories {
	maven { 'https://jitpack.io' }
}

dependencies {
	implementation 'com.github.kss2:LLStream:1.0.1'
}
```
# Usage
```java
String[] result = LLStream.filter(str, s -> s.equals("a"));
Person[] result2 = LLStream.filter(people, elem -> elem.age == 10);
int[] result3 = LLStream.filter(nums, elem -> elem == 1);
ArrayList<Integer> result4 = LLStream.filter(list, elem -> elem == 1);
TreeMap<String, Integer> result5 = LLStream.filter(map, elem -> elem.getKey().equals("banana"));
TreeSet<Integer> result6 = LLStream.filter(set, elem -> elem == 3);
```
# Method
```java
filter
reduce
any
all
count
skip
skipLast
take
takeLast
skipTake
skipTakeLast
indexOf (predicate)
get (findByIndex or findByPredicate)
```
