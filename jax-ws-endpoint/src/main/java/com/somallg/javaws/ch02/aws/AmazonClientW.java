package com.somallg.javaws.ch02.aws;//package ch02.aws;
//
//import awsClient.*;
//
//import javax.xml.ws.Holder;
//import java.util.List;
//
///**
// * Created by somallg on 5/13/14.
// */
//public class AmazonClientW {
//    public static void main(String[] args) {
//        final String access_key = "1A67QRNF7AGRQ1XXMJ07)";
//
//        // Construct a service object to get the port object
//        AWSECommerceService service = new AWSECommerceService();
//        AWSECommerceServicePortType port = service.getAWSECommerceServicePort();
//
//        // Construct an empty request object and the add details
//        ItemSearchRequest request = new ItemSearchRequest();
//        request.setSearchIndex("Books");
//        request.setKeywords("quantum gravity");
//
//        ItemSearch search = new ItemSearch();
//        search.getRequest().add(request);
//        search.setAWSAccessKeyId(access_key);
//
//        Holder<OperationRequest> operation_request = null;
//        Holder<List<Items>> items = new Holder<List<Items>>();
//
//        port.itemSearch(search.getMarketplaceDomain(),
//                search.getAWSAccessKeyId(),
//                search.getAssociateTag(),
//                search.getXMLEscaping(),
//                search.getValidate(),
//                search.getShared(),
//                search.getRequest(),
//                operation_request,
//                items);
//
//        // Unpack the response
//        Items retval = items.value.get(0);
//        List<Item> item_list = retval.getItem();
//        for (Item item : item_list)
//            System.out.println(item.getItemAttributes().getTitle());
//    }
//}
