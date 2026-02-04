// public class Codec {
//     Map<Integer, String> map = new HashMap<>();//ID - longurl
//     private int id = 0;
//     // Encodes a URL to a shortened URL.
//     public String encode(String longUrl) {
//         // 把当前编号和长链接存到字典里
//         // 比如：0 → "https://leetcode.com/xxx"
//         map.put(id, longUrl);
//         return "http://tinyurl.com/"+ id++;
// }

//     // Decodes a shortened URL to its original URL.
//     public String decode(String shortUrl) {
//         int key = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
//         return map.get(key);
//     }
// }

public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return longUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));