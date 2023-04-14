public class SalesPerson {
    private int salesPersonId;
    private String salesPersonName;
    private String city;
    private float commission;

    public SalesPerson(int salesPersonId, String salesPersonName, String city, float commission) {
        this.salesPersonId = salesPersonId;
        this.salesPersonName = salesPersonName;
        this.city = city;
        this.commission = commission;
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "SalesPerson{" +
                "salesPersonId=" + salesPersonId +
                ", salesPersonName='" + salesPersonName + '\'' +
                ", city='" + city + '\'' +
                ", commission=" + commission +
                '}';
    }
}
