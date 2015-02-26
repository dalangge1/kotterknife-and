package butterknife

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.v4.app.Fragment as SupportFragment
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import kotlin.properties.ReadOnlyProperty

public fun <T : View> ViewGroup.bindView(id: Int): ReadOnlyProperty<Any, T> = ViewBinding(id)
public fun <T : View> Activity.bindView(id: Int): ReadOnlyProperty<Any, T> = ViewBinding(id)
public fun <T : View> Dialog.bindView(id: Int): ReadOnlyProperty<Any, T> = ViewBinding(id)
public fun <T : View> Fragment.bindView(id: Int): ReadOnlyProperty<Any, T> = ViewBinding(id)
public fun <T : View> SupportFragment.bindView(id: Int): ReadOnlyProperty<Any, T> = ViewBinding(id)
public fun <T : View> ViewHolder.bindView(id: Int): ReadOnlyProperty<Any, T> = ViewBinding(id)

public fun <T : View> Any.bindView(source: View, id: Int): ReadOnlyProperty<Any, T> = SourcedViewBinding(source, id)
public fun <T : View> Any.bindView(source: ViewGroup, id: Int): ReadOnlyProperty<Any, T> = SourcedViewBinding(source, id)
public fun <T : View> Any.bindView(source: Activity, id: Int): ReadOnlyProperty<Any, T> = SourcedViewBinding(source, id)
public fun <T : View> Any.bindView(source: Dialog, id: Int): ReadOnlyProperty<Any, T> = SourcedViewBinding(source, id)
public fun <T : View> Any.bindView(source: Fragment, id: Int): ReadOnlyProperty<Any, T> = SourcedViewBinding(source, id)
public fun <T : View> Any.bindView(source: SupportFragment, id: Int): ReadOnlyProperty<Any, T> = SourcedViewBinding(source, id)
public fun <T : View> Any.bindView(source: ViewHolder, id: Int): ReadOnlyProperty<Any, T> = SourcedViewBinding(source, id)

public fun <T : View> ViewGroup.bindOptionalView(id: Int): ReadOnlyProperty<Any, T?> = OptionalViewBinding(id)
public fun <T : View> Activity.bindOptionalView(id: Int): ReadOnlyProperty<Any, T?> = OptionalViewBinding(id)
public fun <T : View> Dialog.bindOptionalView(id: Int): ReadOnlyProperty<Any, T?> = OptionalViewBinding(id)
public fun <T : View> Fragment.bindOptionalView(id: Int): ReadOnlyProperty<Any, T?> = OptionalViewBinding(id)
public fun <T : View> SupportFragment.bindOptionalView(id: Int): ReadOnlyProperty<Any, T?> = OptionalViewBinding(id)
public fun <T : View> ViewHolder.bindOptionalView(id: Int): ReadOnlyProperty<Any, T?> = OptionalViewBinding(id)

public fun <T : View> Any.bindOptionalView(source: View, id: Int): ReadOnlyProperty<Any, T?> = OptionalSourcedViewBinding(source, id)
public fun <T : View> Any.bindOptionalView(source: ViewGroup, id: Int): ReadOnlyProperty<Any, T?> = OptionalSourcedViewBinding(source, id)
public fun <T : View> Any.bindOptionalView(source: Activity, id: Int): ReadOnlyProperty<Any, T?> = OptionalSourcedViewBinding(source, id)
public fun <T : View> Any.bindOptionalView(source: Dialog, id: Int): ReadOnlyProperty<Any, T?> = OptionalSourcedViewBinding(source, id)
public fun <T : View> Any.bindOptionalView(source: Fragment, id: Int): ReadOnlyProperty<Any, T?> = OptionalSourcedViewBinding(source, id)
public fun <T : View> Any.bindOptionalView(source: SupportFragment, id: Int): ReadOnlyProperty<Any, T?> = OptionalSourcedViewBinding(source, id)
public fun <T : View> Any.bindOptionalView(source: ViewHolder, id: Int): ReadOnlyProperty<Any, T?> = OptionalSourcedViewBinding(source, id)

public fun <T : View> ViewGroup.bindViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = ViewListBinding(ids)
public fun <T : View> Activity.bindViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = ViewListBinding(ids)
public fun <T : View> Dialog.bindViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = ViewListBinding(ids)
public fun <T : View> Fragment.bindViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = ViewListBinding(ids)
public fun <T : View> SupportFragment.bindViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = ViewListBinding(ids)
public fun <T : View> ViewHolder.bindViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = ViewListBinding(ids)

public fun <T : View> Any.bindViews(source: View, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = SourcedViewListBinding(source, ids)
public fun <T : View> Any.bindViews(source: ViewGroup, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = SourcedViewListBinding(source, ids)
public fun <T : View> Any.bindViews(source: Activity, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = SourcedViewListBinding(source, ids)
public fun <T : View> Any.bindViews(source: Dialog, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = SourcedViewListBinding(source, ids)
public fun <T : View> Any.bindViews(source: Fragment, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = SourcedViewListBinding(source, ids)
public fun <T : View> Any.bindViews(source: SupportFragment, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = SourcedViewListBinding(source, ids)
public fun <T : View> Any.bindViews(source: ViewHolder, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = SourcedViewListBinding(source, ids)

public fun <T : View> ViewGroup.bindOptionalViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalViewListBinding(ids)
public fun <T : View> Activity.bindOptionalViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalViewListBinding(ids)
public fun <T : View> Dialog.bindOptionalViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalViewListBinding(ids)
public fun <T : View> Fragment.bindOptionalViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalViewListBinding(ids)
public fun <T : View> SupportFragment.bindOptionalViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalViewListBinding(ids)
public fun <T : View> ViewHolder.bindOptionalViews(vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalViewListBinding(ids)

public fun <T : View> Any.bindOptionalViews(source: View, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalSourcedViewListBinding(source, ids)
public fun <T : View> Any.bindOptionalViews(source: ViewGroup, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalSourcedViewListBinding(source, ids)
public fun <T : View> Any.bindOptionalViews(source: Activity, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalSourcedViewListBinding(source, ids)
public fun <T : View> Any.bindOptionalViews(source: Dialog, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalSourcedViewListBinding(source, ids)
public fun <T : View> Any.bindOptionalViews(source: Fragment, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalSourcedViewListBinding(source, ids)
public fun <T : View> Any.bindOptionalViews(source: SupportFragment, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalSourcedViewListBinding(source, ids)
public fun <T : View> Any.bindOptionalViews(source: ViewHolder, vararg ids: Int): ReadOnlyProperty<Any, List<T>> = OptionalSourcedViewListBinding(source, ids)

private fun findView<T : View>(thisRef: Any, id: Int): T? {
  [suppress("UNCHECKED_CAST")]
  return when (thisRef) {
    is View -> thisRef.findViewById(id)
    is Activity -> thisRef.findViewById(id)
    is Dialog -> thisRef.findViewById(id)
    is Fragment -> thisRef.getView().findViewById(id)
    is SupportFragment -> thisRef.getView().findViewById(id)
    is ViewHolder -> thisRef.itemView.findViewById(id)
    else -> throw IllegalStateException("Unable to find views on type.")
  } as T?
}

private class ViewBinding<T : View>(val id: Int) : ReadOnlyProperty<Any, T> {
  private val lazy = Lazy<T>()

  override fun get(thisRef: Any, desc: PropertyMetadata): T = lazy.get {
    findView<T>(thisRef, id)
        ?: throw IllegalStateException("View ID $id for '${desc.name}' not found.")
  }
}

private class SourcedViewBinding<T : View>(val source: Any, val id: Int) : ReadOnlyProperty<Any, T> {
  private val lazy = Lazy<T>()

  override fun get(thisRef: Any, desc: PropertyMetadata): T = lazy.get {
    findView<T>(source, id)
        ?: throw IllegalStateException("View ID $id for '${desc.name}' not found.")
  }
}

private class OptionalViewBinding<T : View>(val id: Int) : ReadOnlyProperty<Any, T?> {
  private val lazy = Lazy<T?>()

  override fun get(thisRef: Any, desc: PropertyMetadata): T? = lazy.get {
    findView<T>(thisRef, id)
  }
}

private class OptionalSourcedViewBinding<T : View>(val source: Any, val id: Int) : ReadOnlyProperty<Any, T?> {
  private val lazy = Lazy<T?>()

  override fun get(thisRef: Any, desc: PropertyMetadata): T? = lazy.get {
    findView<T>(source, id)
  }
}

private class ViewListBinding<T : View>(val ids: IntArray) : ReadOnlyProperty<Any, List<T>> {
  private var lazy = Lazy<List<T>>()

  override fun get(thisRef: Any, desc: PropertyMetadata): List<T> = lazy.get {
    ids.map { id -> findView<T>(thisRef, id)
        ?: throw IllegalStateException("View ID $id for '${desc.name}' not found.")
    }
  }
}

private class SourcedViewListBinding<T : View>(val source: Any, val ids: IntArray) : ReadOnlyProperty<Any, List<T>> {
  private var lazy = Lazy<List<T>>()

  override fun get(thisRef: Any, desc: PropertyMetadata): List<T> = lazy.get {
    ids.map { id -> findView<T>(source, id)
        ?: throw IllegalStateException("View ID $id for '${desc.name}' not found.")
    }
  }
}

private class OptionalViewListBinding<T : View>(val ids: IntArray) : ReadOnlyProperty<Any, List<T>> {
  private var lazy = Lazy<List<T>>()

  override fun get(thisRef: Any, desc: PropertyMetadata): List<T> = lazy.get {
    ids.map { id -> findView<T>(thisRef, id) }.filterNotNull()
  }
}

private class OptionalSourcedViewListBinding<T : View>(val source: Any, val ids: IntArray) : ReadOnlyProperty<Any, List<T>> {
  private var lazy = Lazy<List<T>>()

  override fun get(thisRef: Any, desc: PropertyMetadata): List<T> = lazy.get {
    ids.map { id -> findView<T>(source, id) }.filterNotNull()
  }
}

private class Lazy<T> {
  private object EMPTY
  private var value: Any? = EMPTY

  fun get(initializer: () -> T): T {
    if (value == EMPTY) {
      value = initializer.invoke()
    }
    [suppress("UNCHECKED_CAST")]
    return value as T
  }
}
