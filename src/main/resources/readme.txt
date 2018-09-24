每次客户端访问服务端的时候都把session带过来，如此做有如下好处：
1、openid未暴露。服务端看到传递过来的session，就可以从redis中找到相应的openid以及解密用的session_key。
2、每当session失效的时候，客户端会重新获取一次，如同游戏编程中的心跳，保持连接。


http://patorjk.com/software/taag/#p=display&f=Doom&t=naner180