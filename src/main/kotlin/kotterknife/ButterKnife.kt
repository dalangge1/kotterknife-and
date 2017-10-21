package kotterknife

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import android.support.v4.app.DialogFragment as SupportDialogFragment
import android.support.v4.app.Fragment as SupportFragment

public fun <V : View> View.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)
public fun <V : View> Activity.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)
public fun <V : View> Dialog.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)
public fun <V : View> DialogFragment.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)
public fun <V : View> SupportDialogFragment.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)
public fun <V : View> Fragment.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)
public fun <V : View> SupportFragment.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)
public fun <V : View> ViewHolder.bindView(id: Int)
    : ReadOnlyProperty<Any?, V> = required(id, viewFinder)

public fun <V : View> View.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)
public fun <V : View> Activity.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)
public fun <V : View> Dialog.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)
public fun <V : View> DialogFragment.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)
public fun <V : View> SupportDialogFragment.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)
public fun <V : View> Fragment.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)
public fun <V : View> SupportFragment.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)
public fun <V : View> ViewHolder.bindOptionalView(id: Int)
    : ReadOnlyProperty<Any?, V?> = optional(id, viewFinder)

public fun <V : View> View.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)
public fun <V : View> Activity.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)
public fun <V : View> Dialog.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)
public fun <V : View> DialogFragment.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)
public fun <V : View> SupportDialogFragment.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)
public fun <V : View> Fragment.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)
public fun <V : View> SupportFragment.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)
public fun <V : View> ViewHolder.bindViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = required(ids, viewFinder)

public fun <V : View> View.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)
public fun <V : View> Activity.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)
public fun <V : View> Dialog.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)
public fun <V : View> DialogFragment.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)
public fun <V : View> SupportDialogFragment.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)
public fun <V : View> Fragment.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)
public fun <V : View> SupportFragment.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)
public fun <V : View> ViewHolder.bindOptionalViews(vararg ids: Int)
    : ReadOnlyProperty<Any?, List<V>> = optional(ids, viewFinder)

private val View.viewFinder: (Int) -> View?
    get() = { findViewById(it) }
private val Activity.viewFinder: (Int) -> View?
    get() = { findViewById(it) }
private val Dialog.viewFinder: (Int) -> View?
    get() = { findViewById(it) }
private val DialogFragment.viewFinder: (Int) -> View?
    get() = { dialog?.findViewById(it) ?: view?.findViewById(it) }
private val SupportDialogFragment.viewFinder: (Int) -> View?
    get() = { dialog?.findViewById(it) ?: view?.findViewById(it) }
private val Fragment.viewFinder: (Int) -> View?
    get() = { view.findViewById(it) }
private val SupportFragment.viewFinder: (Int) -> View?
    get() = { view!!.findViewById(it) }
private val ViewHolder.viewFinder: (Int) -> View?
    get() = { itemView.findViewById(it) }

private fun viewNotFound(id:Int, desc: KProperty<*>): Nothing =
    throw IllegalStateException("View ID $id for '${desc.name}' not found.")

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(id: Int, finder: (Int) -> View?)
    = Lazy<T, V> { desc -> finder(id) as V? ?: viewNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(id: Int, finder: (Int) -> View?)
    = Lazy<T, V?> { finder(id) as V? }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(ids: IntArray, finder: (Int) -> View?)
    = Lazy<T, List<V>> { desc -> ids.map { finder(it) as V? ?: viewNotFound(it, desc) } }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(ids: IntArray, finder: (Int) -> View?)
    = Lazy<T, List<V>> { ids.map { finder(it) as V? }.filterNotNull() }

// Like Kotlin's lazy delegate but the initializer gets the target and metadata passed to it
private class Lazy<T, V>(private val initializer: (KProperty<*>) -> V) : ReadOnlyProperty<T, V> {
  private object EMPTY
  private var value: Any? = EMPTY

  override fun getValue(thisRef: T, property: KProperty<*>): V {
    if (value == EMPTY) {
      value = initializer(property)
    }
    @Suppress("UNCHECKED_CAST")
    return value as V
  }
}
