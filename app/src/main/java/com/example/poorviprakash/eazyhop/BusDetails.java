package com.example.poorviprakash.eazyhop;

public class BusDetails {
    String dataSourcePlace;
    String datadestinationPlace;
    int dataAdult;
    int dataChild;
    int dataSrC;

    public BusDetails(String dataSourcePlace, String datadestinationPlace, int dataAdult, int dataChild, int dataSrC) {
        this.dataSourcePlace = dataSourcePlace;
        this.datadestinationPlace = datadestinationPlace;
        this.dataAdult = dataAdult;
        this.dataChild = dataChild;
        this.dataSrC = dataSrC;
    }

    public BusDetails() {
    }

    public String getDataSourcePlace() {
        return dataSourcePlace;
    }

    public String getDatadestinationPlace() {
        return datadestinationPlace;
    }

    public int getDataAdult() {
        return dataAdult;
    }

    public int getDataChild() {
        return dataChild;
    }

    public int getDataSrC() {
        return dataSrC;
    }

    public void setDataSourcePlace(String dataSourcePlace) {
        this.dataSourcePlace = dataSourcePlace;
    }

    public void setDatadestinationPlace(String datadestinationPlace) {
        this.datadestinationPlace = datadestinationPlace;
    }

    public void setDataAdult(int dataAdult) {
        this.dataAdult = dataAdult;
    }

    public void setDataChild(int dataChild) {
        this.dataChild = dataChild;
    }

    public void setDataSrC(int dataSrC) {
        this.dataSrC = dataSrC;
    }
}
