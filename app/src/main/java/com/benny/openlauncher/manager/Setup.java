package com.benny.openlauncher.manager;

import android.content.Context;

import com.benny.openlauncher.interfaces.DialogListener;
import com.benny.openlauncher.model.Item;
import com.benny.openlauncher.util.AppManager;
import com.benny.openlauncher.util.AppSettings;
import com.benny.openlauncher.util.DatabaseHelper;
import com.benny.openlauncher.util.Definitions;
import com.benny.openlauncher.viewutil.DesktopGestureListener;
import com.benny.openlauncher.viewutil.ItemGestureListener;

import java.util.List;

public abstract class Setup {

    // ----------------
    // Class and singleton
    // ----------------

    private static Setup _setup = null;

    public static boolean wasInitialised() {
        return _setup != null;
    }

    public static void init(Setup setup) {
        Setup._setup = setup;
    }

    public static Setup get() {
        if (_setup == null) {
            throw new RuntimeException("Setup has not been initialised!");
        }
        return _setup;
    }

    // ----------------
    // Methods for convenience and shorter code
    // ----------------

    public static Context appContext() {
        return get().getAppContext();
    }

    public static AppSettings appSettings() {
        return get().getAppSettings();
    }

    public static DesktopGestureListener.DesktopGestureCallback desktopGestureCallback() {
        return get().getDesktopGestureCallback();
    }

    public static ItemGestureListener.ItemGestureCallback itemGestureCallback() {
        return get().getItemGestureCallback();
    }

    public static DatabaseHelper dataManager() {
        return get().getDataManager();
    }

    public static AppManager appLoader() {
        return get().getAppLoader();
    }

    public static EventHandler eventHandler() {
        return get().getEventHandler();
    }

    public static Logger logger() {
        return get().getLogger();
    }

    // ----------------
    // Settings
    // ----------------

    public abstract Context getAppContext();

    public abstract AppSettings getAppSettings();

    public abstract DesktopGestureListener.DesktopGestureCallback getDesktopGestureCallback();

    public abstract ItemGestureListener.ItemGestureCallback getItemGestureCallback();

    public abstract DatabaseHelper getDataManager();

    public abstract AppManager getAppLoader();

    public abstract EventHandler getEventHandler();

    public abstract Logger getLogger();

    // ----------------
    // Interfaces
    // ----------------

    public interface EventHandler {
        void showLauncherSettings(Context context);

        void showPickAction(Context context, DialogListener.OnAddActionListener listener);

        void showEditDialog(Context context, Item item, DialogListener.OnEditDialogListener listener);

        void showDeletePackageDialog(Context context, Item item);
    }

    public interface Logger {
        void log(Object source, int priority, String tag, String msg, Object... args);
    }
}
