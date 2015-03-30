package Microminer;

import java.util.ArrayList;

public class SearchResult {
    String keyword;
    ArrayList<URLInfo> urlInfo = new ArrayList<>();

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public ArrayList<URLInfo> getUrls() {
        return urlInfo;
    }

    public void setUrls(ArrayList<URLInfo> urls) {
        this.urlInfo = urls;
    }
    
    public void add(URLInfo urlinfo){
        this.urlInfo.add(urlinfo);
    }
    
}
