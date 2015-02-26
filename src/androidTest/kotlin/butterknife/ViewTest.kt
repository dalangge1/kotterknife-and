package butterknife

import android.content.Context
import android.widget.FrameLayout
import android.widget.TextView
import android.test.AndroidTestCase
import android.view.View
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertEquals

public class ViewTest : AndroidTestCase() {
  public fun testCast() {
    class Example(context: Context) : FrameLayout(context) {
      val name : TextView by bindView(1)
    }

    val example = Example(getContext())
    example.addView(textViewWithId(1))
    assertNotNull(example.name)
  }

  public fun testCastWithSource() {
    class Source(context: Context) : FrameLayout(context)

    class Example(source: Source) {
      val name: TextView by bindView(source, 1)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(textViewWithId(1))
    assertNotNull(example.name)
  }

  public fun testFindCached() {
    class Example(context: Context) : FrameLayout(context) {
      val name : View by bindView(1)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    assertNotNull(example.name)
    example.removeAllViews()
    assertNotNull(example.name)
  }

  public fun testFindCachedWithSource() {
    class Source(context: Context) : FrameLayout(context)

    class Example(source: Source) {
      val name: TextView by bindView(source, 1)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(textViewWithId(1))
    source.addView(viewWithId(1))
    assertNotNull(example.name)
    source.removeAllViews()
    assertNotNull(example.name)
  }

  public fun testOptional() {
    class Example(context: Context) : FrameLayout(context) {
      val present: View? by bindOptionalView(1)
      val missing: View? by bindOptionalView(2)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    assertNotNull(example.present)
    assertNull(example.missing)
  }

  public fun testOptionalWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val present: View? by bindOptionalView(source, 1)
      val missing: View? by bindOptionalView(source, 2)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(viewWithId(1))
    assertNotNull(example.present)
    assertNull(example.missing)
  }

  public fun testOptionalCached() {
    class Example(context: Context) : FrameLayout(context) {
      val present: View? by bindOptionalView(1)
      val missing: View? by bindOptionalView(2)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    assertNotNull(example.present)
    assertNull(example.missing)
    example.removeAllViews()
    example.addView(viewWithId(2))
    assertNotNull(example.present)
    assertNull(example.missing)
  }

  public fun testOptionalCachedWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val present: View? by bindOptionalView(source, 1)
      val missing: View? by bindOptionalView(source, 2)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(viewWithId(1))
    assertNotNull(example.present)
    assertNull(example.missing)
    source.removeAllViews()
    source.addView(viewWithId(2))
    assertNotNull(example.present)
    assertNull(example.missing)
  }

  public fun testMissingFails() {
    class Example(context: Context) : FrameLayout(context) {
      val name : TextView? by bindView(1)
    }

    val example = Example(getContext())
    try {
      example.name
    } catch (e: IllegalStateException) {
      assertEquals("View ID 1 for 'name' not found.", e.getMessage())
    }
  }

  public fun testMissingFailsWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val name : TextView? by bindView(source, 1)
    }

    val source = Source(getContext())
    val example = Example(source)
    try {
      example.name
    } catch (e: IllegalStateException) {
      assertEquals("View ID 1 for 'name' not found.", e.getMessage())
    }
  }

  public fun testList() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindViews(1, 2, 3)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    example.addView(viewWithId(2))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(3, example.name.size)
  }

  public fun testListWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val name : List<TextView> by bindViews(source, 1, 2, 3)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(viewWithId(1))
    source.addView(viewWithId(2))
    source.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(3, example.name.size)
  }

  public fun testListCaches() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindViews(1, 2, 3)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    example.addView(viewWithId(2))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(3, example.name.size)
    example.removeAllViews()
    assertNotNull(example.name)
    assertEquals(3, example.name.size)
  }

  public fun testListCachesWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val name : List<TextView> by bindViews(source, 1, 2, 3)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(viewWithId(1))
    source.addView(viewWithId(2))
    source.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(3, example.name.size)
    source.removeAllViews()
    assertNotNull(example.name)
    assertEquals(3, example.name.size)
  }

  public fun testListMissingFails() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindViews(1, 2, 3)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    example.addView(viewWithId(3))
    try {
      example.name
    } catch (e: IllegalStateException) {
      assertEquals("View ID 2 for 'name' not found.", e.getMessage())
    }
  }

  public fun testListMissingFailsWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val name : List<TextView> by bindViews(source, 1, 2, 3)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(viewWithId(1))
    source.addView(viewWithId(3))
    try {
      example.name
    } catch (e: IllegalStateException) {
      assertEquals("View ID 2 for 'name' not found.", e.getMessage())
    }
  }

  public fun testOptionalList() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindOptionalViews(1, 2, 3)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(2, example.name.size)
  }

  public fun testOptionalListWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val name : List<TextView> by bindOptionalViews(source, 1, 2, 3)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(viewWithId(1))
    source.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(2, example.name.size)
  }

  public fun testOptionalListCaches() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindOptionalViews(1, 2, 3)
    }

    val example = Example(getContext())
    example.addView(viewWithId(1))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(2, example.name.size)
    example.removeAllViews()
    assertNotNull(example.name)
    assertEquals(2, example.name.size)
  }

  public fun testOptionalListCachesWithSource() {
    class Source(context: Context) : FrameLayout(context)
    class Example(source: Source) {
      val name : List<TextView> by bindOptionalViews(source, 1, 2, 3)
    }

    val source = Source(getContext())
    val example = Example(source)
    source.addView(viewWithId(1))
    source.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(2, example.name.size)
    source.removeAllViews()
    assertNotNull(example.name)
    assertEquals(2, example.name.size)
  }

  private fun viewWithId(id: Int) : View {
    val view = View(getContext())
    view.setId(id)
    return view
  }

  private fun textViewWithId(id: Int) : View {
    val view = TextView(getContext())
    view.setId(id)
    return view
  }
}
