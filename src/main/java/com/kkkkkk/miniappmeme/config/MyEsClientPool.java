// package com.kkkkkk.miniappmeme.config;
//
// import org.apache.commons.pool2.PooledObject;
// import org.apache.commons.pool2.PooledObjectFactory;
// import org.apache.commons.pool2.impl.DefaultPooledObject;
// import org.apache.commons.pool2.impl.GenericObjectPool;
// import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
// import org.apache.http.HttpHost;
// import org.elasticsearch.client.RestClient;
// import org.elasticsearch.client.RestHighLevelClient;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
//
// /**
//  * @author jennie
//  * @create 2021-10-25 22:58
//  */
// @Component
// public class MyEsClientPool {
//     //private static final String HOST = "192.168.20.138"; // 集群节点
//     //private static final int PORT = 9200;
//     // 对象池配置类，不写也可以，采用默认配置
//     private GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//
//     // 采用默认配置maxTotal是8，池中有8个client
//     public MyEsClientPool() {
//
//         poolConfig.setMaxTotal(20);
//
//         poolConfig.setMaxIdle(5);
//
//         poolConfig.setTestWhileIdle(true);
//         poolConfig.setTestOnBorrow(false);
//
//         poolConfig.setTimeBetweenEvictionRunsMillis(300000L);
//         poolConfig.setMinIdle(5);
//     }
//
//     @Autowired
//     public ESConf esConf;
//
//     private GenericObjectPool<RestHighLevelClient> clientPool = new GenericObjectPool<RestHighLevelClient>(new PooledObjectFactory<RestHighLevelClient>() {
//
//         public PooledObject<RestHighLevelClient> makeObject() throws Exception {
//             RestHighLevelClient client = null;
//             try {
//                 client = new RestHighLevelClient(RestClient.builder(new HttpHost(esConf.getHost(), esConf.getPort(), "http")));
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//             return new DefaultPooledObject<RestHighLevelClient>(client);
//         }
//
//         public void destroyObject(PooledObject<RestHighLevelClient> pooledObject) throws Exception {
//             RestHighLevelClient client = pooledObject.getObject();
//             client.close();
//         }
//
//         public boolean validateObject(PooledObject<RestHighLevelClient> pooledObject) {
//             return true;
//         }
//
//         public void activateObject(PooledObject<RestHighLevelClient> pooledObject) throws Exception {
//             System.out.println("激活客户端");
//         }
//
//         public void passivateObject(PooledObject<RestHighLevelClient> pooledObject) throws Exception {
//             System.out.println("释放客户端");
//         }
//     }, poolConfig);
//
//     /**
//      * 获得对象
//      *
//      * @return
//      * @throws Exception
//      */
//     public RestHighLevelClient getClient() throws Exception {
//
//         RestHighLevelClient client = clientPool.borrowObject();
//         return client;
//     }
//
//     /**
//      * 归还对象
//      *
//      * @param client
//      */
//     public void returnClient(RestHighLevelClient client) {
//         if (client != null) {
//             clientPool.returnObject(client);
//         }
//     }
//
//
//     /*public static void main(String[] args) throws Exception {
//         RestHighLevelClient client = MyEsClientPool.getClient();
//         System.out.println(client);
//     }*/
// }
//
