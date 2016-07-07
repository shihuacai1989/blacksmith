# blacksmith

## 一、简介

finagle-thrift-demo

使用finagle+thrift搭建的一个项目

## 二、主要依赖：finagle-thrift_2.10
```
<dependency>
    <groupId>com.twitter</groupId>
    <artifactId>finagle-thrift_2.10</artifactId>
    <version>6.35.0</version>
</dependency>
```

主要需要考虑的问题是scala的版本依赖和对thrift的版本依赖，这两个问题。
比如在项目中同事需要finagle和kafka的时候，考虑scala的版本冲突问题。
目前（2016-06-23）finagle和kafka对scala的2.10和2.11都在同时升级，本项目中使用的是2.10版本

<div class="version-section"><h2>Compile Dependencies (4)</h2><style>
.im-logo { margin-right: 0}
</style><table class="grid" style="vertical-align: middle" width="100%"><thead><tr><th style="width: 12em; text-align: center">Category/License</th><th style="width: 28px"></th><th>
Group / Artifact</th><th style="text-align: center">Version</th><th style="text-align: center">Updates</th></tr></thead><tbody><tr><td style="text-align: right"><a href="/open-source/distributed-communication" class="b c">Distributed Communication</a><br><span class="b lic">apache</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/5ee09bc0e403a88ba906755a01295f8e"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/e4ebb175bf5fca6951b77c82894d281a"></picture></td><td><a href="/artifact/com.twitter">com.twitter</a>
» <a href="/artifact/com.twitter/finagle-core_2.10">finagle-core_2.10</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/com.twitter/finagle-core_2.10/6.35.0">
6.35.0</a></td><td style="text-align: center">
✔
</td></tr><tr><td style="text-align: right"><br><span class="b lic">apache</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/5ee09bc0e403a88ba906755a01295f8e"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/e4ebb175bf5fca6951b77c82894d281a"></picture></td><td><a href="/artifact/com.twitter">com.twitter</a>
» <a href="/artifact/com.twitter/scrooge-core_2.10">scrooge-core_2.10</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/com.twitter/scrooge-core_2.10/4.7.0">
4.7.0</a></td><td style="text-align: center">
✔
</td></tr><tr><td style="text-align: right"><a href="/open-source/object-serialization" class="b c">Serializer</a><br><span class="b lic">apache</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/e7cb46f555e94ff3aa028516b43da4bb"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/b6af8a130aeaecd8c7254839a2dfabab"></picture></td><td><a href="/artifact/org.apache.thrift">org.apache.thrift</a>
» <a href="/artifact/org.apache.thrift/libthrift">libthrift</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.apache.thrift/libthrift/0.5.0-1">
0.5.0-1</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.apache.thrift/libthrift/0.9.3">0.9.3</a></td></tr><tr><td style="text-align: right"><a href="/open-source/language-runtime" class="b c">Lang Runtime</a><br><span class="b lic">bsd</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/3bb5bcdea54fad3c261687d8b5fc411d"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/2c884ab9e717c94fcece07ad5677d3e7"></picture></td><td><a href="/artifact/org.scala-lang">org.scala-lang</a>
» <a href="/artifact/org.scala-lang/scala-library">scala-library</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scala-lang/scala-library/2.10.6">
2.10.6</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scala-lang/scala-library/2.11.8">2.11.8</a></td></tr></tbody></table></div>

<div class="version-section"><h2>Provided Dependencies (3)</h2><style>
.im-logo { margin-right: 0}
</style><table class="grid" style="vertical-align: middle" width="100%"><thead><tr><th style="width: 12em; text-align: center">Category/License</th><th style="width: 28px"></th><th>
Group / Artifact</th><th style="text-align: center">Version</th><th style="text-align: center">Updates</th></tr></thead><tbody><tr><td style="text-align: right"><br><span class="b lic">apache</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/d63f89a19a3ab3d445a2bcf1d1533a96"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/4278f8180de5297596c0964837a0f7f4"></picture></td><td><a href="/artifact/org.scoverage">org.scoverage</a>
» <a href="/artifact/org.scoverage/scalac-scoverage-plugin_2.10">scalac-scoverage-plugin_2.10</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scoverage/scalac-scoverage-plugin_2.10/1.1.0">
1.1.0</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scoverage/scalac-scoverage-plugin_2.10/1.1.1">1.1.1</a></td></tr><tr><td style="text-align: right"><br><span class="b lic">apache</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/d63f89a19a3ab3d445a2bcf1d1533a96"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/4278f8180de5297596c0964837a0f7f4"></picture></td><td><a href="/artifact/org.scoverage">org.scoverage</a>
» <a href="/artifact/org.scoverage/scalac-scoverage-runtime_2.10">scalac-scoverage-runtime_2.10</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scoverage/scalac-scoverage-runtime_2.10/1.1.0">
1.1.0</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scoverage/scalac-scoverage-runtime_2.10/1.1.1">1.1.1</a></td></tr><tr><td style="text-align: right"><a href="/open-source/logging-frameworks" class="b c">Logging</a><br><span class="b lic">mit</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/b7c83df66e2ffa6db21d578aea94bfd5"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/ebaccb6488ec3cd6879842fb30407555"></picture></td><td><a href="/artifact/org.slf4j">org.slf4j</a>
» <a href="/artifact/org.slf4j/slf4j-api">slf4j-api</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.slf4j/slf4j-api/1.7.7">
1.7.7</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.slf4j/slf4j-api/1.7.21">1.7.21</a></td></tr></tbody></table></div>

<div class="version-section"><h2>Test Dependencies (5)</h2><style>
.im-logo { margin-right: 0}
</style><table class="grid" style="vertical-align: middle" width="100%"><thead><tr><th style="width: 12em; text-align: center">Category/License</th><th style="width: 28px"></th><th>
Group / Artifact</th><th style="text-align: center">Version</th><th style="text-align: center">Updates</th></tr></thead><tbody><tr><td style="text-align: right"><a href="/open-source/testing-frameworks" class="b c">Testing</a><br><span class="b lic">epl</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/d0f73ecf7a2ecdc8f1082e67dbb5617d"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/7cb2d4617d97415f562bd5711c429a95"></picture></td><td><a href="/artifact/junit">junit</a>
» <a href="/artifact/junit/junit">junit</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/junit/junit/4.10">
4.10</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/junit/junit/4.12">4.12</a></td></tr><tr><td style="text-align: right"><a href="/open-source/mocking" class="b c">Mocking</a><br><span class="b lic">mit</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/883ab1fd45b7243b298b18790e70cf3e"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/ab8655889ce452e2fa4713aa13b8428f"></picture></td><td><a href="/artifact/org.mockito">org.mockito</a>
» <a href="/artifact/org.mockito/mockito-all">mockito-all</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.mockito/mockito-all/1.9.5">
1.9.5</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.mockito/mockito-all/1.10.19">1.10.19</a></td></tr><tr><td style="text-align: right"><a href="/open-source/testing-frameworks" class="b c">Testing</a><br><span class="b lic">bsd</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/68ad00d0f70902d41e8ea2a473785f63"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/bd3c4dacf9531cf95d9c1f77b737eaf1"></picture></td><td><a href="/artifact/org.scalacheck">org.scalacheck</a>
» <a href="/artifact/org.scalacheck/scalacheck_2.10">scalacheck_2.10</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scalacheck/scalacheck_2.10/1.12.2">
1.12.2</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scalacheck/scalacheck_2.10/1.13.1">1.13.1</a></td></tr><tr><td style="text-align: right"><a href="/open-source/testing-frameworks" class="b c">Testing</a><br><span class="b lic">apache</span></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/631886495fb5116fc2a2f35bdfa138b5"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/7a661545feb3d061428b106572b5eba0"></picture></td><td><a href="/artifact/org.scalatest">org.scalatest</a>
» <a href="/artifact/org.scalatest/scalatest_2.10">scalatest_2.10</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scalatest/scalatest_2.10/2.2.4">
2.2.4</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/org.scalatest/scalatest_2.10/2.2.6">2.2.6</a></td></tr><tr><td style="text-align: right"><br></td><td><picture><source type="image/webp" srcset="https://d2j3q9yua85jt3.cloudfront.net/img/361c5c4ae2df2279a9eaf1fe2296e6fb"><img class="im-logo" width="28" height="28" src="https://d2j3q9yua85jt3.cloudfront.net/img/fee90797f7fb8d9fab107543a422e22f"></picture></td><td><a href="/artifact/silly">silly</a>
» <a href="/artifact/silly/silly-thrift">silly-thrift</a></td><td style="text-align: center"><a class="vbtn release" href="/artifact/silly/silly-thrift/0.5.0">
0.5.0</a></td><td style="text-align: center">
✔
</td></tr></tbody></table></div>

## 三、maven编译thrift插件