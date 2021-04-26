package com.util.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import org.apache.axis.components.net.TransportClientProperties;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.*;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.*;
import org.elasticsearch.transport.Transport;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;

/**
 * @author sunyiban
 * @title: CommonUtils
 * @copyright: Copyright (c) 2021
 * @description: <br>
 * @created on 2021/4/20 9:52
 */
public class ElasticSearchUtil {

    public static void main(String[] args) throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

//        Settings settings = Settings.builder()
//                .put("cluster.name", "myClusterName").build();
//        TransportClient client = new PreBuiltTransportClient(settings);

        // 使用term查询不到数据，原因说是client的bugε=(´ο｀*)))，相比match，term不会使用分词
        /*SearchResponse response = client.prepareSearch("bank")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery("email", "elinorratliff@scentric.com"))                 // Query
//                .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(38))     // Filter
                .setFrom(0).setSize(10).setExplain(true)
                .get();

        System.out.println(JSONObject.toJSONString(response));*/

//        multiSearch(client);

//        aggregations(client);
//        indexDocument(client);

//        updateDocument(client);

        createIndex();

        client.close();
    }

    public static void createIndex() throws Exception {
        String mapperJson ="{\r\n" +
                "        \"properties\": {\r\n" +
                "            \"productId\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "			\"productName\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "			\"supplierId\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "			\"supplierName\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "			\"prodCode\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "			\"prodName\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "			\"title_py\": {\r\n" +
                "               \"type\": \"text\",\r\n" +
                "                \"fields\": {\r\n" +
                "                    \"pinyin\": {\r\n" +
                "                        \"type\": \"text\",\r\n" +
                "                        \"store\": false,\r\n" +
                "                        \"term_vector\": \"with_offsets\",\r\n" +
                "                        \"analyzer\": \"pinyin_analyzer\",\r\n" +
                "                        \"boost\": 10\r\n" +
                "                    }\r\n" +
                "                }\r\n" +
                "            },\r\n" +
                "            \r\n" +
                "            \"title\": {\r\n" +
                "                \"type\": \"text\",\r\n" +
                "				 \"analyzer\": \"by_smart\",\r\n" +
                "				  \"search_analyzer\":\"by_smart\"\r\n" +
                "            },\r\n" +
                "            \r\n" +
                "			\"description\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "			\"imageUrl\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "			\"soldNum\": {\r\n" +
                "                \"type\": \"integer\"\r\n" +
                "            },\r\n" +
                "			\"minPrice\": {\r\n" +
                "                \"type\": \"double\"\r\n" +
                "            },\r\n" +
                "			\"maxPrice\": {\r\n" +
                "                \"type\": \"double\"\r\n" +
                "            },\r\n" +
                "			\"status\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "			\"arrayParentName\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "			\"arrayParentId\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "			\"path\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "			\"shelveTimeStr\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "            \"shelveTime\": {\r\n" +
                "                \"type\": \"long\"\r\n" +
                "            },\r\n" +
                "			\"offshelveTimeStr\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "            \"offshelveTime\": {\r\n" +
                "                \"type\": \"long\"\r\n" +
                "            },\r\n" +
                "			\"price\": {\r\n" +
                "                \"type\": \"double\"\r\n" +
                "            },\r\n" +
                "            \r\n" +
                "            \"canSearch\": {\r\n" +
                "                \"type\": \"integer\"\r\n" +
                "            },\r\n" +
                "            \"categoryName\": {\r\n" +
                "               \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"productcode\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"productid\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"keywords\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"categorycode\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"soldnum\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"cansearch\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"plate\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"brandname\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"arrayparentid\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"categorytype\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"arrayparentname\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"minprice\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"remark_2\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"prodclasscode\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"remark_1\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"unitname\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"productname\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"shelvetime\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"area\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"supplierid\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"maxprice\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"pricedescription\": {\r\n" +
                "                \"type\": \"text\"\r\n" +
                "            },\r\n" +
                "          \"minpriceskuid\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"channelname\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"brandcode\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"channelcode\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"suppliername\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"offshelvetimestr\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"imageurl\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"shelvetimestr\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"categoryname\": {\r\n" +
                "                \"type\": \"keyword\"\r\n" +
                "            },\r\n" +
                "          \"vipprice\": {\r\n" +
                "                \"type\": \"double\"\r\n" +
                "            },\r\n" +
                "         \r\n" +
                "            \"props\":{\r\n" +
                "            	 \"type\": \"nested\",\r\n" +
                "            	 \"include_in_parent\":true,\r\n" +
                "            	 \"properties\":{\r\n" +
                "            	 	\"key\":{\r\n" +
                "            	 		\"type\": \"text\"\r\n" +
                "            	 	},\r\n" +
                "            	 	\"val\":{\r\n" +
                "            	 		\"type\": \"text\"\r\n" +
                "            	 	},\r\n" +
                "            	 	\"des\":{\r\n" +
                "            	 		\"type\": \"keyword\"\r\n" +
                "            	 	},\r\n" +
                "            	 	\"group\":{\r\n" +
                "            	 		\"type\": \"text\"\r\n" +
                "            	 	}\r\n" +
                "            	 }\r\n" +
                "            }\r\n" +
                "            \r\n" +
                "        }\r\n" +
                "}";

        String settingJson =" {\r\n" +
                "        \"analysis\" : {\r\n" +
                "            \"analyzer\" : {\r\n" +
                "                \"pinyin_analyzer\" : {\r\n" +
                "                    \"tokenizer\" : \"my_pinyin\"\r\n" +
                "                    },\r\n" +
                "	                 \"by_smart\": {\r\n" +
                "			          \"type\": \"custom\",\r\n" +
                "			          \"tokenizer\": \"ik_smart\",\r\n" +
                "			          \"filter\": [\"by_tfr\",\"by_sfr\"],\r\n" +
                "			          \"char_filter\": [\"by_cfr\"]\r\n" +
                "			        },\r\n" +
                "			        \"by_max_word\": {\r\n" +
                "			          \"type\": \"custom\",\r\n" +
                "			          \"tokenizer\": \"ik_max_word\",\r\n" +
                "			          \"filter\": [\"by_tfr\",\"by_sfr\"],\r\n" +
                "			          \"char_filter\": [\"by_cfr\"]\r\n" +
                "			        }\r\n" +
                "            },\r\n" +
                "            \r\n" +
                "            \"filter\":{\r\n" +
                "	            	\"by_tfr\": {\r\n" +
                "	          \"type\": \"stop\",\r\n" +
                "	          \"stopwords\": [\" \"]\r\n" +
                "	        },\r\n" +
                "	        \"by_sfr\": {\r\n" +
                "	          \"type\": \"synonym\",\r\n" +
                "	          \"synonyms_path\": \"analysis/synonyms.txt\"\r\n" +
                "	        }\r\n" +
                "            },\r\n" +
                "            \r\n" +
                "             \"char_filter\": {\r\n" +
                "        \"by_cfr\": {\r\n" +
                "          \"type\": \"mapping\",\r\n" +
                "          \"mappings\": [\"| => |\"]\r\n" +
                "        }\r\n" +
                "      },\r\n" +
                "            \r\n" +
                "            \"tokenizer\" : {\r\n" +
                "                \"my_pinyin\" : {\r\n" +
                "                    \"type\" : \"pinyin\",\r\n" +
                "                    \"keep_separate_first_letter\" : false,\r\n" +
                "                    \"keep_full_pinyin\" : true,\r\n" +
                "                    \"keep_original\" : true,\r\n" +
                "                    \"limit_first_letter_length\" : 16,\r\n" +
                "                    \"lowercase\" : true,\r\n" +
                "                    \"remove_duplicated_term\" : true\r\n" +
                "                }\r\n" +
                "            }\r\n" +
                "        }\r\n" +
                "    }";

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("product1");
        createIndexRequest.settings(settingJson, XContentType.JSON);
        createIndexRequest.mapping(mapperJson, XContentType.JSON);

        Node node = new Node(new HttpHost("127.0.0.1", 9200, "http"));
        RestClientBuilder restClientBuilder = RestClient.builder(node);

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);
        CreateIndexResponse response = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        System.out.println(JSONObject.toJSONString(response));

        restHighLevelClient.close();

    }

    public static void indexDocument(TransportClient client) throws Exception {
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("user", "ccse")
                .field("postDate", new Date())
                .field("message", "this is Elasticsearch")
                .endObject();
        IndexResponse response = client.prepareIndex("twitter", "_doc", "1")
                .setSource(builder)
                .get();

        // Index name
        String _index = response.getIndex();
        // Type name
        String _type = response.getType();
        // Document ID (generated or not)
        String _id = response.getId();
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
        // status has stored current instance statement.
        RestStatus status = response.status();
    }

    public static void updateDocument(TransportClient client) throws Exception {
        UpdateRequest updateRequest = new UpdateRequest("sun", "yi", "1")
                .doc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "ban")
                        .endObject());
        client.update(updateRequest).get();
    }

    public static void multiSearch(TransportClient client) {
        SearchRequestBuilder srb1 = client
                .prepareSearch().setQuery(QueryBuilders.queryStringQuery("firstname")).setSize(1);
        SearchRequestBuilder srb2 = client
                .prepareSearch().setQuery(QueryBuilders.matchQuery("email", "elinorratliff@scentric.com")).setSize(1);

        MultiSearchResponse sr = client.prepareMultiSearch()
                .add(srb1)
                .add(srb2)
                .get();

        // You will get all individual responses from MultiSearchResponse#getResponses()
        long nbHits = 0;
        for (MultiSearchResponse.Item item : sr.getResponses()) {
            SearchResponse response = item.getResponse();
            nbHits += response.getHits().getTotalHits().value;
        }

        System.out.println(nbHits);
    }

    /**
     * 使用term报错
     * Caused by: NotSerializableExceptionWrapper[: Text fields are not optimised for operations that require per-document field data like aggregations and sorting, so these operations are disabled by default. Please use a keyword field instead. Alternatively, set fielddata=true on [gender] in order to load field data by uninverting the inverted index. Note that this can use significant memory.]; nested: IllegalArgumentException[Text fields are not optimised for operations that require per-document field data like aggregations and sorting, so these operations are disabled by default. Please use a keyword field instead. Alternatively, set fielddata=true on [gender] in order to load field data by uninverting the inverted index. Note that this can use significant memory.];
     * 原因 字符串类型的数据默认没有优化，没有优化的字段es默认是禁止聚合/排序操作的。所以需要将要聚合的字段添加优化
     * @param client
     */
    public static void aggregations(TransportClient client) {
        SearchResponse sr = client.prepareSearch("bank")
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(
                        AggregationBuilders.max("agg1").field("age")
                )
                .addAggregation(
                        AggregationBuilders.avg("agg2")
                                .field("age")
                )
                .get();

        // Get your facet results
        Max agg1 = sr.getAggregations().get("agg1");
        Avg agg2 = sr.getAggregations().get("agg2");

        System.out.println(JSONObject.toJSONString(agg1));

        System.out.println(JSONObject.toJSONString(agg2));

        StatsAggregationBuilder aggregation =
                AggregationBuilders
                        .stats("agg")
                        .field("age");
        sr = client.prepareSearch("bank").addAggregation(aggregation).get();

        Stats agg = sr.getAggregations().get("agg");
        double min = agg.getMin();
        double max = agg.getMax();
        double avg = agg.getAvg();
        double sum = agg.getSum();
        long count = agg.getCount();

        System.out.println("************************************************");
        System.out.println(JSONObject.toJSONString(sr));

        PercentilesAggregationBuilder aggregation1 =
                AggregationBuilders
                        .percentiles("agg")
                        .field("age")
                        .percentiles(1.0, 5.0, 10.0, 20.0, 30.0, 75.0, 95.0, 99.0);

        sr = client.prepareSearch("bank").addAggregation(aggregation1).get();

        System.out.println("percentile:" + JSONObject.toJSONString(sr));

        // sr is here your SearchResponse object
        Percentiles agg3 = sr.getAggregations().get("agg");
        // For each entry
        for (Percentile entry : agg3) {
            double percent = entry.getPercent();    // Percent
            double value = entry.getValue();        // Value

            System.out.println("percent [" + percent + "], value ["+ value +  "]");
        }
    }
}
