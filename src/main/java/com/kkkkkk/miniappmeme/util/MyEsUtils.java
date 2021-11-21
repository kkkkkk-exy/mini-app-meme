// package com.kkkkkk.miniappmeme.util;
//
// import com.kkkkkk.miniappmeme.config.MyEsClientPool;
// import org.elasticsearch.client.RestHighLevelClient;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
//
// /**
//  * @author jennie
//  * @create 2021-10-28 23:12
//  */
// @Component
// public class MyEsUtils {
//
//     private static RestHighLevelClient client = null;
//
//     @Autowired
//     private MyEsClientPool myEsClientPool;
//
//     //获取客户端
//     public RestHighLevelClient getRestHighLevelClient(){
//         if (client == null){
//             try {
//                 client = myEsClientPool.getClient();
//             } catch (Exception e){
//                 e.printStackTrace();
//             }
//         }
//         return client;
//     }
//
//     //关闭客户端
//     public void closeClient(){
//         if(client != null){
//             myEsClientPool.returnClient(client);
//         }
//     }
// }
