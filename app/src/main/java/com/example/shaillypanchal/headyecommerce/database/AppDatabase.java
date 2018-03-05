package com.example.shaillypanchal.headyecommerce.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.shaillypanchal.headyecommerce.database.interfaces.CategoryDAO;
import com.example.shaillypanchal.headyecommerce.database.interfaces.ProductDAO;
import com.example.shaillypanchal.headyecommerce.database.interfaces.RankingsDAO;
import com.example.shaillypanchal.headyecommerce.database.interfaces.VariantsDAO;
import com.example.shaillypanchal.headyecommerce.database.tables.CategoryTable;
import com.example.shaillypanchal.headyecommerce.database.tables.ProductTable;
import com.example.shaillypanchal.headyecommerce.database.tables.RankingsTable;
import com.example.shaillypanchal.headyecommerce.database.tables.VariantsTable;

/**
 * Created by shaillypanchal on 03/03/18.
 */
@Database(entities = {ProductTable.class, CategoryTable.class, VariantsTable.class, RankingsTable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ProductDAO productDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract VariantsDAO variantsDAO();
    public abstract RankingsDAO rankingsDAO();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the codelab, allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
