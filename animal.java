package org.example;
public class animal {
    private String description;
    private String name;
    private String type;

    private String noise;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public animal(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public animal(){};

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public static boolean isType(String type){
    String lowercaseType = type.toLowerCase();
    return lowercaseType.equals("mammal") || lowercaseType.equals("reptile") || lowercaseType.equals("amphibian");
    }
}
