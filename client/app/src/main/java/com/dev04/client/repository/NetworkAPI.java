
package com.dev04.client.repository;



import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetworkAPI {
    private static final String SERVER_BASE_URL = "http://172.30.1.43:9407/"; // TODO - IP 를 서버 PC 의 IP로 설정해주어야 함.

    private static NetworkAPI INSTANCE;

    public static NetworkAPI getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NetworkAPI();
        }
        return INSTANCE;
    }

    private final MemberService memberService;

    private NetworkAPI() {
        memberService = new Retrofit.Builder()
                .baseUrl(SERVER_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(MemberService.class);
    }

    public MemberService getMemberService() {
        return memberService;
    }
}

