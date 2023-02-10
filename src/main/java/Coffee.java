public class Coffee {
    private int id;
    private double aroma;
    private double acidity;
    private double sweetness;
    private double score;
    private double price;
    private String type;
    private String producer;
    private String region;
    private String country;

    public Coffee(int id, double aroma, double acidity, double sweetness, double score, double price, String type, String producer, String region, String country) {
        this.id = id;
        this.aroma = aroma;
        this.acidity = acidity;
        this.sweetness = sweetness;
        this.score = score;
        this.price = price;
        this.type = type;
        this.producer = producer;
        this.region = region;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", aroma=" + aroma +
                ", acidity=" + acidity +
                ", sweetness=" + sweetness +
                ", score=" + score +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
