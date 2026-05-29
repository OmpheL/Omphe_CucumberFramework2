package models;

public class Group {

    private String name;
    private String description;
    private String year;
    private String capacity;
    private String startDate;
    private String endDate;

    public Group(String name,
                 String description,
                 String year,
                 String capacity,
                 String startDate,
                 String endDate) {

        this.name = name;
        this.description = description;
        this.year = year;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getYear() {
        return year;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}