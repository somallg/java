package com.somallg.javaws.ch02.aws;//package ch02.aws;
//
///**
// * Created by somallg on 5/13/14.
// */
//public class AmazonClientU {
//    public static void main(String[] args) {
//        final String access_key = "";
//
//        // Create service and get portType reference.
//        AWSECommerceService service = new AWSECommerceService();
//        AWSECommerceServicePortType port =
//                service.getAWSECommerceServicePort();
//// Create request.
//        ItemSearchRequest request = new ItemSearchRequest();
//// Add details to request.
//        request.setSearchIndex("Books");
//        request.setKeywords("quantum gravity");
//        ItemSearch item_search= new ItemSearch();
//        item_search.setAWSAccessKeyId(access_key);
//        item_search.getRequest().add(request);
//// Invoke service operation and get response.
//        ItemSearchResponse response = port.itemSearch(item_search);
//    }
//    List<Items> item_list = response.getItems();
//    for (Items next : item_list)
//            for (Item item : next.getItem())
//            System.out.println(item.getItemAttributes().getTitle());
//
//}
//}
