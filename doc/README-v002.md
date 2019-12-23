# 02 - `이클립스 IDE`로 프로젝트 다루기

1) 그레이들의 빌드 스크립트 파일에 이클립스 플러그인을 추가한다.

build.gradle 파일에 'eclipse' 플러그인을 추가한다.

```
plugins {
    id 'java'
    id 'application'
    id 'eclipse'
}
```

2) 이클립스 IDE에서 사용할 프로젝트 설정 파일을 생성한다.

```
$ gradle eclipse
```

3) 이클립스 IDE의 워크스페이스로 프로젝트를 가져온다.

4) 이클립스 IDE에서 프로젝트를 실행한다.

