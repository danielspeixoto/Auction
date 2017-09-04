package util;

import mock.*;
import model.pojo.*;

public class Convert {

    // Cria um user baseando-se na linha que contém seus dados
    public static User userFrom(String string) {
        String arr[] = getArr(string);
        return new User(Integer.valueOf(arr[UserDatabase.INDEX_ID]),
                arr[UserDatabase.INDEX_NAME], arr[UserDatabase.INDEX_EMAIL],
                arr[UserDatabase.INDEX_PASSWORD]);
    }

    public static Item itemFrom(String string) {
        String arr[] = getArr(string);
        switch (arr[ItemDatabase.INDEX_TYPE]) {
            case "m":
                return new Misc(Integer.valueOf(arr[ItemDatabase.INDEX_ID]),
                        Integer.valueOf(arr[ItemDatabase.INDEX_OWNER]), arr[ItemDatabase.INDEX_NAME],
                        arr[ItemDatabase.INDEX_DESCRIPTION], Double.valueOf(arr[MiscDatabase.INDEX_LENGTH]),
                        Double.valueOf(arr[MiscDatabase.INDEX_WIDTH]), Double.valueOf(arr[MiscDatabase.INDEX_HEIGHT]),
                        Double.valueOf(arr[MiscDatabase.INDEX_WEIGHT]), arr[MiscDatabase.INDEX_CONTAINER_DESCRIPTION]);

            case "r":
                return new Realty(Integer.valueOf(arr[ItemDatabase.INDEX_ID]),
                        Integer.valueOf(arr[ItemDatabase.INDEX_OWNER]), arr[ItemDatabase.INDEX_NAME],
                        arr[ItemDatabase.INDEX_DESCRIPTION], arr[RealtyDatabase.INDEX_LOCATION],
                        Double.valueOf(arr[RealtyDatabase.INDEX_SQUARE_METERS]),
                        Integer.valueOf(arr[RealtyDatabase.INDEX_CONSTRUCTION_YEAR]));
            case "f":
                return new Fluid(Integer.valueOf(arr[ItemDatabase.INDEX_ID]),
                        Integer.valueOf(arr[ItemDatabase.INDEX_OWNER]), arr[ItemDatabase.INDEX_NAME],
                        arr[ItemDatabase.INDEX_DESCRIPTION], arr[FluidDatabase.INDEX_CONTAINER_DESCRIPTION],
                        Double.valueOf(arr[FluidDatabase.INDEX_CONTAINER_LENGTH]),
                        Double.valueOf(arr[FluidDatabase.INDEX_CONTAINER_WIDTH]),
                        Double.valueOf(arr[FluidDatabase.INDEX_CONTAINER_HEIGHT]),
                        Double.valueOf(arr[FluidDatabase.INDEX_VOLUME]),
                        Double.valueOf(arr[FluidDatabase.INDEX_RADIUS]),
                        Double.valueOf(arr[FluidDatabase.INDEX_WEIGHT]));
            default:
                return new Vehicle(Integer.valueOf(arr[ItemDatabase.INDEX_ID]),
                        Integer.valueOf(arr[ItemDatabase.INDEX_OWNER]), arr[ItemDatabase.INDEX_NAME],
                        arr[ItemDatabase.INDEX_DESCRIPTION], arr[VehicleDatabase.INDEX_MILEAGE],
                        arr[VehicleDatabase.INDEX_BRAND], arr[VehicleDatabase.INDEX_MODEL],
                        Integer.valueOf(arr[VehicleDatabase.INDEX_DOORS]),
                        arr[VehicleDatabase.INDEX_FUEL],
                        arr[VehicleDatabase.INDEX_COLOR],
                        Integer.valueOf(arr[VehicleDatabase.INDEX_SEATS]),
                        arr[VehicleDatabase.INDEX_MOTOR_DESCRIPTION],
                        arr[VehicleDatabase.INDEX_CHASSIS]);
        }
    }

    public static Auction auctionFrom(String string) {
        String arr[] = getArr(string);
        return new Auction(
                Integer.valueOf(arr[AuctionDatabase.INDEX_ID]),
                Integer.valueOf(arr[AuctionDatabase.PATH_MIN_PERCENT_FOR_NEW_BIDS]),
                Long.valueOf(arr[AuctionDatabase.PATH_EXPIRATION_TIME]),
                Long.valueOf(arr[AuctionDatabase.PATH_LAST_BID_MILLIS]),
                Integer.valueOf(arr[AuctionDatabase.PATH_LAST_BIDDER_ID]),
                Integer.valueOf(arr[AuctionDatabase.PATH_ITEM_ID]),
                Integer.valueOf(arr[AuctionDatabase.PATH_OWNER_ID]),
                Double.valueOf(arr[AuctionDatabase.PATH_LAST_BID])
        );
    }


    public static Account accountFrom(String line) {
        String arr[] = getArr(line);
        return new Account(Integer.valueOf(arr[AccountDatabase.INDEX_USER_ID]),
                Double.valueOf(arr[AccountDatabase.INDEX_BALANCE]),Double.valueOf(arr[AccountDatabase.INDEX_FRONZEN_BALANCE]));
    }

    private static String[] getArr(String str) {
        return str.split(Database.SPLIT);
    }
}
