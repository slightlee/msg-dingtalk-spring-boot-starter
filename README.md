### 介绍

> 自定义钉钉机器人发送群消息集成
>
> 钉钉官方文档地址：https://open.dingtalk.com/document/orgapp/custom-robots-send-group-messages#h2-ygj-edd-8xo

### 支持消息类型

- [x] 文本类型消息
- [x] 链接类型消息
- [x] markdown类型消息
- [x] actionCard类型消息
- [x] feedCard类型消息

### 使用步骤

#### 本地仓库使用

> 引入依赖

```xml
<dependency>
  <groupId>com.demain</groupId>
  <artifactId>msg-dingtalk-spring-boot-starter</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

> 配置文件

```yaml
msg:
  dingtalk:
    url: 你的webhook地址
    secret: 你的密钥
```

> 请求测试

```java
@RestController
public class MsgSendController {

    private final DingTalkSend dingTalkSend;

    public indexController(DingTalkSend dingTalkSend) {
        this.dingTalkSend = dingTalkSend;
    }

    @RequestMapping("/sendMsg")
    public boolean sendMsg() throws IOException {
        DingTalkTextMessage dingTalkTextMessage1 = new DingTalkTextMessage("文本通知消息1");
        DingTalkResponse response = dingTalkSend.sendMessage(dingTalkTextMessage1);
        return response.isSuccess();
        // true or false
    }
}
```

#### 线上仓库使用

> 待完善...

### 更多示例

> 更多示例可参考源码单元测试
