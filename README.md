# sou4j-microsoft-cognitive-luis

## Support API

| API                                                                | since  |
| :----------------------------------------------------------------- | :----- |
| apps - Publish application                                         | v0.1.0 |
| example utterances - Add label                                     | v0.1.0 |
| example utterances - Batch add labels                              | v0.1.0 |
| example utterances - Delete example labels                         | v0.1.0 |
| models - Add closed list's sublist                                 | v0.1.0 |
| models - Create entity                                             | v0.1.0 |
| models - Create intent                                             | v0.1.0 |
| models - Delete entity                                             | v0.1.0 |
| models - Delete intent                                             | v0.1.0 |
| models - Delete sublist entity                                     | v0.1.0 |
| models - Get closed list entity                                    | v0.1.0 |
| models - Rename entity                                             | v0.1.0 |
| models - Update closed list entity                                 | v0.1.0 |
| train - Get version training status                                | v0.1.0 |
| train - Train application version                                  | v0.1.0 |

## Usage

### pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project ...>
  [...]
  <repositories>
    [...]
    <repository>
      <id>sou4j</id>
      <name>sou4j</name>
      <url>https://raw.githubusercontent.com/oscasierra/sou4j-mvn-repo/master/</url>
    </repository>
    [...]
  </repositories>

  <dependencies>
    [...]
    <dependency>
      <groupId>jp.sou4j</groupId>
      <artifactId>sou4j-microsoft-cognitive-luis</artifactId>
      <version>0.1.0</version>
    </dependency>
    [...]
  </dependencies>
</project>

```
