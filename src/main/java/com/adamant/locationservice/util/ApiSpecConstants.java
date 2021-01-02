package com.adamant.locationservice.util;

public final class ApiSpecConstants {

    private ApiSpecConstants() {
    }

    //User management api spec constants
    public static final String LIST_ALL_USERS_SUCCESS_RESPONSE = "{\n" +
            "  \"total\": 2,\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"id\": \"1243567388\",\n" +
            "      \"firstName\": \"Kamal Deshan\",\n" +
            "      \"lastName\": \"Wijewardhana\",\n" +
            "      \"avatarUrl\": \"http://a0.twimg.com/pf/148462/kamal123.jpg\",\n" +
            "      \"email\": \"kamaldesh@gmail.com\",\n" +
            "      \"activated\": true,\n" +
            "      \"signInCount\": 223,\n" +
            "      \"createdAt\": 1608964676,\n" +
            "      \"updatedAt\": 1608964696,\n" +
            "      \"groups\": [\n" +
            "        \"10\",\n" +
            "        \"16\"\n" +
            "      ],\n" +
            "      \"roles\": [\n" +
            "        \"1\",\n" +
            "        \"4\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"7243267387\",\n" +
            "      \"firstName\": \"Nayana\",\n" +
            "      \"lastName\": \"Samarasinghe\",\n" +
            "      \"avatarUrl\": \"http://a0.twimg.com/pf/148462/nayana44.jpg\",\n" +
            "      \"email\": \"nayanasm@gmail.com\",\n" +
            "      \"activated\": true,\n" +
            "      \"signInCount\": 125,\n" +
            "      \"createdAt\": 1608964666,\n" +
            "      \"updatedAt\": 1608964686\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String CREATE_USER_SUCCESS_RESPONSE = "{\n" +
            "  \"id\": \"1243567388\",\n" +
            "  \"firstName\": \"Kamal Deshan\",\n" +
            "  \"lastName\": \"Wijewardhana\",\n" +
            "  \"avatarUrl\": \"http://a0.twimg.com/pf/148462/kamal123.jpg\",\n" +
            "  \"email\": \"kamaldesh@gmail.com\",\n" +
            "  \"activated\": true,\n" +
            "  \"signInCount\": 223,\n" +
            "  \"createdAt\": 1608964676,\n" +
            "  \"updatedAt\": 1608964696,\n" +
            "  \"groups\": [\n" +
            "    \"10\",\n" +
            "    \"16\"\n" +
            "  ],\n" +
            "  \"roles\": [\n" +
            "    \"1\",\n" +
            "    \"4\"\n" +
            "  ]\n" +
            "}";

    public static final String RETRIEVE_USER_SUCCESS_RESPONSE = "{\n" +
            "  \"id\": \"1243567388\",\n" +
            "  \"firstName\": \"Kamal Deshan\",\n" +
            "  \"lastName\": \"Wijewardhana\",\n" +
            "  \"avatarUrl\": \"http://a0.twimg.com/pf/148462/kamal123.jpg\",\n" +
            "  \"email\": \"kamaldesh@gmail.com\",\n" +
            "  \"activated\": true,\n" +
            "  \"signInCount\": 223,\n" +
            "  \"createdAt\": 1608964676,\n" +
            "  \"updatedAt\": 1608964696,\n" +
            "  \"groups\": [\n" +
            "    \"10\",\n" +
            "    \"16\"\n" +
            "  ],\n" +
            "  \"roles\": [\n" +
            "    \"1\",\n" +
            "    \"4\"\n" +
            "  ]\n" +
            "}";

    public static final String UPDATE_USER_SUCCESS_RESPONSE = "{\n" +
            "  \"id\": \"1243567388\",\n" +
            "  \"firstName\": \"Kamal Deshan\",\n" +
            "  \"lastName\": \"Wijewardhana\",\n" +
            "  \"avatarUrl\": \"http://a0.twimg.com/pf/148462/kamal123.jpg\",\n" +
            "  \"email\": \"kamaldesh@gmail.com\",\n" +
            "  \"activated\": true,\n" +
            "  \"signInCount\": 223,\n" +
            "  \"createdAt\": 1608964676,\n" +
            "  \"updatedAt\": 1608964696,\n" +
            "  \"groups\": [\n" +
            "    \"10\",\n" +
            "    \"16\"\n" +
            "  ],\n" +
            "  \"roles\": [\n" +
            "    \"1\",\n" +
            "    \"4\"\n" +
            "  ]\n" +
            "}";

    public static final String LIST_ALL_GROUPS_SUCCESS_RESPONSE = "{\n" +
            "  \"total\": 2,\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"id\": \"1243567388\",\n" +
            "      \"name\": \"Admin\",\n" +
            "      \"activated\": true,\n" +
            "      \"createdAt\": 1608964676,\n" +
            "      \"updatedAt\": 1608964696\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"9243567378\",\n" +
            "      \"name\": \"Operator\",\n" +
            "      \"activated\": true,\n" +
            "      \"createdAt\": 1608964676,\n" +
            "      \"updatedAt\": 1608964696\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String CREATE_GROUP_SUCCESS_RESPONSE = "{\n" +
            "  \"name\": \"Admin\",\n" +
            "  \"roles\": [\n" +
            "    \"1\",\n" +
            "    \"4\"\n" +
            "  ]\n" +
            "}";

    public static final String RETRIEVE_GROUP_SUCCESS_RESPONSE = "{\n" +
            "  \"id\": \"1243567388\",\n" +
            "  \"name\": \"Admin\",\n" +
            "  \"createdAt\": 1608964676,\n" +
            "  \"updatedAt\": 1608964696,\n" +
            "  \"roles\": [\n" +
            "    \"1\",\n" +
            "    \"4\"\n" +
            "  ]\n" +
            "}";

    public static final String UPDATE_GROUP_SUCCESS_RESPONSE = "{\n" +
            "  \"id\": \"1243567388\",\n" +
            "  \"name\": \"Admin\",\n" +
            "  \"createdAt\": 1608964676,\n" +
            "  \"updatedAt\": 1608964696,\n" +
            "  \"roles\": [\n" +
            "    \"1\",\n" +
            "    \"4\"\n" +
            "  ]\n" +
            "}";

    public static final String LIST_ALL_ROLES_SUCCESS_RESPONSE = "xample Value\n" +
            "Schema\n" +
            "{\n" +
            "  \"total\": 2,\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"id\": \"1243567388\",\n" +
            "      \"name\": \"Till Operator\",\n" +
            "      \"createdAt\": 1608964676,\n" +
            "      \"updatedAt\": 1608964696,\n" +
            "      \"allowedOperations\": [\n" +
            "        \"till_transactions\",\n" +
            "        \"withdraw_money\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"1243567388\",\n" +
            "      \"name\": \"ERP Admin\",\n" +
            "      \"createdAt\": 1608964676,\n" +
            "      \"updatedAt\": 1608964696,\n" +
            "      \"allowedOperations\": [\n" +
            "        \"erp_transactions\",\n" +
            "        \"confirm_po\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String CREATE_ROLE_SUCCESS_RESPONSE = "{\n" +
            "  \"name\": \"Till Operator\",\n" +
            "  \"allowedOperations\": [\n" +
            "    \"till_transactions\",\n" +
            "    \"withdraw_money\"\n" +
            "  ]\n" +
            "}";

    public static final String RETRIEVE_ROLE_SUCCESS_RESPONSE = "{\n" +
            "  \"id\": \"1243567388\",\n" +
            "  \"name\": \"Admin\",\n" +
            "  \"createdAt\": 1608964676,\n" +
            "  \"updatedAt\": 1608964696,\n" +
            "  \"allowedOperations\": [\n" +
            "    \"till_transactions\",\n" +
            "    \"withdraw_money\"\n" +
            "  ]\n" +
            "}";

    public static final String UPDATE_ROLE_SUCCESS_RESPONSE = "{\n" +
            "  \"id\": \"1243567388\",\n" +
            "  \"name\": \"Admin\",\n" +
            "  \"createdAt\": 1608964676,\n" +
            "  \"updatedAt\": 1608964696,\n" +
            "  \"allowedOperations\": [\n" +
            "    \"till_transactions\",\n" +
            "    \"withdraw_money\"\n" +
            "  ]\n" +
            "}";
}
