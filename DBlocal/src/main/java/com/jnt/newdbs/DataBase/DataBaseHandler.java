package com.jnt.newdbs.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseHandler {

    private SQLiteDatabase sqLiteDatabase;
    private SQLiteHelper sqLiteHelper;
    //private Context context;

    public DataBaseHandler(Context _context) {
        //context = _context;
        sqLiteHelper = new SQLiteHelper(_context);
    }

    public void open() {
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

    }

    /*public void close() {
        sqLiteDatabase.close();
    }*/
    /////////////

    /**
     * @param marketModel
     * @return
     */
    /*public boolean insertOne(MarketModel marketModel) {
        open();
        ContentValues cv = new ContentValues();
        cv.put(Fields.TableMarket.COLUMN_MARKET_NAME, marketModel.getMarketName());
        cv.put(Fields.TableMarket.COLUMN_MARKET_ADDRESS, marketModel.getAddress());
        cv.put(Fields.TableMarket.COLUMN_MARKET_ACTIVE, marketModel.isActive());

        long insert = sqLiteDatabase.insert(Fields.TableMarket.MARKET_TABLE, null, cv);
        close();
        return insert != -1;
    }*/

    /**
     * @param productModel
     * @return
     */
    /*public boolean insertOne(ProductModel productModel) {
        open();
        ContentValues cv = new ContentValues();
        cv.put(Fields.TableProduct.COLUMN_PRODUCT_NAME, productModel.getProductName());
        cv.put(Fields.TableProduct.COLUMN_PRODUCT_PRICE, productModel.getPrice());
        cv.put(Fields.TableProduct.COLUMN_PRODUCT_ACTIVE, productModel.isActive());

        long insert = sqLiteDatabase.insert(Fields.TableProduct.PRODUCT_TABLE, null, cv);
        close();
        return insert != -1;
    }*/

    // get all market for list all
    /*public ArrayList<MarketModel> getAllMarket() {

        ArrayList<MarketModel> returnList = new ArrayList<>();
        // get data from database
        String queryString = "SELECT * FROM " + Fields.TableMarket.MARKET_TABLE;
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new customer objects . put them into the return list
            do {
                int marketID = cursor.getInt(0);
                String marketName = cursor.getString(1);
                String marketAddress = cursor.getString(2);
                boolean marketActive = cursor.getInt(3) == 1;
                //boolean marketActive = cursor.getInt(3) == 1 ? true : false;

                MarketModel market = new MarketModel(marketID, marketName, marketAddress, marketActive);
                returnList.add(market);

            } while (cursor.moveToNext());

        } else {
            // failure. do not add anything to the list
        }
        // close both the cursor and and the db when done
        cursor.close();
        db.close();
        return returnList;
    }*/

    // get all product for list all
    /*public ArrayList<ProductModel> getAllProduct() {

        ArrayList<ProductModel> returnList = new ArrayList<>();
        // get data from database
        String queryString = "SELECT * FROM " + Fields.TableProduct.PRODUCT_TABLE;
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new customer objects . put them into the return list
            do {
                int productID = cursor.getInt(0);
                String productName = cursor.getString(1);
                String productPrice = cursor.getString(2);
                boolean productActive = cursor.getInt(3) == 1;

                ProductModel product = new ProductModel(productID, productName, productPrice, productActive);
                returnList.add(product);

            } while (cursor.moveToNext());

        } else {
            // failure. do not add anything to the list
        }
        // close both the cursor and and the db when done
        cursor.close();
        db.close();
        return returnList;
    }*/

    /*public List<MarketModel> getSearch(MarketModel marketModel) {

        List<MarketModel> returnList = new ArrayList<>();

        // get data from database
        String queryString = "SELECT * FROM " + Fields.TableMarket.MARKET_TABLE;
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new customer objects . put them into the return list
            do {
                int customerID = cursor.getInt(0);
                String customerName = cursor.getString(1);
                String customerAddress = cursor.getString(2);
                boolean customerActive = cursor.getInt(3) == 1;

                MarketModel newCustomer = new MarketModel(customerID, customerName, customerAddress, customerActive);
                returnList.add(newCustomer);

            } while (cursor.moveToNext());

        } else {
            // failure. do not add anything to the list
        }
        // close both the cursor and and the db when done
        cursor.close();
        db.close();
        return returnList;
    }*/

    /*public boolean delete(int id) {
        SQLiteDatabase database = sqLiteHelper.getWritableDatabase();
        return database.delete(Fields.TableMarket.MARKET_TABLE, Fields.TableMarket._ID + "=" + id, null) > 0;

    }*/

    /**
     * @param marketModel
     * @return
     */
    /*public boolean update(MarketModel marketModel) {

        open();
        ContentValues cv = new ContentValues();
        cv.put(Fields.TableMarket.COLUMN_MARKET_NAME, marketModel.getMarketName());
        cv.put(Fields.TableMarket.COLUMN_MARKET_ADDRESS, marketModel.getAddress());
        cv.put(Fields.TableMarket.COLUMN_MARKET_ACTIVE, marketModel.isActive());
        Log.e("jvd = name ", marketModel.getMarketName());
        Log.e("jvd = address ", marketModel.getAddress());
        Log.e("jvd = active ", String.valueOf(marketModel.isActive()));

        boolean i = sqLiteDatabase.update(Fields.TableMarket.MARKET_TABLE, cv, Fields.TableMarket._ID + " = " + marketModel.getId(), null) == 1;
        close();
        Log.e("jvd = 3 update: ", String.valueOf(i));
        return i;
    }*/

    /*public int count(String TableName) {
        SQLiteDatabase database = sqLiteHelper.getReadableDatabase();
        Cursor cursor = database.query(TableName, null, null, null, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        database.close();
        return count;
    }*/

}
