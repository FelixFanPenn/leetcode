public class Codec {
    
    Map<String, String> index = new HashMap<>();
    Map<String, String> revIndex = new HashMap<>();
    String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String base;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int last = longUrl.lastIndexOf('/');
        base = longUrl.substring(0, last);
        String url = longUrl.substring(last+1);
        if (index.containsKey(url)) {
            return base + "/" + index.get(url);
        }
        String str = "";
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * charSet.length());
            str += charSet.charAt(index);
        }
        
        index.put(url, str);
        revIndex.put(str, url);
        
        return base + "/" + str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int last = shortUrl.lastIndexOf('/');
        String url = shortUrl.substring(last+1);
        return base + "/" + revIndex.get(url);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));