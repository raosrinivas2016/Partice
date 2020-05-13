package general.desigingClasses;

public class StaticFactoryMethodInsteadOfConstructor {

    public StaticFactoryMethodInsteadOfConstructor() {
        /*you can initialize variables and call different methods here
         */

    }

    private static class Pen {

        String Color;
        java.util.Date DateOfManufacture;
        int Size;
        int Price;

        String Country;

        public Pen( String color, String country ) {
            Color = color;
            Country = country;
        }

        Pen() {
            this.Color = "Red";
            this.Country = "India";
            this.DateOfManufacture = new java.util.Date();
        }

        public Pen( String color, java.util.Date dateOfManufacture, int size, int price, String country ) {
            Color = color;
            DateOfManufacture = dateOfManufacture;
            Size = size;
            Price = price;
            Country = country;
        }

        public Pen( String color, java.util.Date dateOfManufacture, int size ) {
            Color = color;
            DateOfManufacture = dateOfManufacture;
            Size = size;
        }
        /* you can have getter & setter methods*/
    }
}
