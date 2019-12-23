# 01 - 자바 애플리케이션 프로젝트 만들기

1) 자바 애플리케이션 프로젝트 폴더를 준비한다.

```
src/
  main/
    java/
    resources/
  test/
    java/
    resources/
gradle/
build.gradle
settings.gradle
gradlew
gradlew.bat
```

2) 프로젝트 디렉토리를 준비한다.

로컬 Git 저장소에 자바 프로젝트 폴더를 생성한다.

```
$ mkdir TEMA-review-food
$ cd TEMA-review-food
```

프로젝트 폴더를 자바 애플리케이션 프로젝트로 초기화시킨다.
```
$ gradle init
```

자바 소스 파일 외의 기타 파일을 보관할 디렉토리 생성

```
$ cd src/main
$ mkdir resources
$ cd ../test
$ mkdir resources
```

3) 'gradle'의 빌드 스크립트 파일을 편집한다.

build.gradle 파일에 다음 설정을 추가한다.

```
tasks.withType(JavaCompile) {
    options.encoding = 'UTF-8'
    sourceCompatibility = '1.8'
    targetCompatibility = '1.8'
}
```

4) 프로젝트를 빌드한다.

```
$ gradle build
```

5) 프로젝트를 실행한다.

```
$ gradle run
```

