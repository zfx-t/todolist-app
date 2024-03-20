package top.zfxt.Todo

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import top.zfxt.Todo.db.RoomDB
import top.zfxt.Todo.ui.viewmodel.InputBoxViewModel
import top.zfxt.Todo.ui.viewmodel.ToDoListViewModel

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(Appmodule)
        }
    }
}

val Appmodule = module {
    single { RoomDB.getInstance(androidContext()) }

    viewModel { InputBoxViewModel(get<RoomDB>().ToDoItemDao()) }
    viewModel { ToDoListViewModel(get<RoomDB>().ToDoItemDao()) }

}