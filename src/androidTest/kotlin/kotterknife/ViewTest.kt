package kotterknife

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import android.test.AndroidTestCase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

public class ViewTest : AndroidTestCase() {
  public fun testCast() {
    class Example(context: Context) : FrameLayout(context) {
      val name : TextView by bindView(1)
    }

    val example = Example(context)
    example.addView(textViewWithId(1))
    assertNotNull(example.name)
  }

  public fun testFindCached() {
    class Example(context: Context) : FrameLayout(context) {
      val name : View by bindView(1)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    assertNotNull(example.name)
    example.removeAllViews()
    assertNotNull(example.name)
  }

  public fun testOptional() {
    class Example(context: Context) : FrameLayout(context) {
      val present: View? by bindOptionalView(1)
      val missing: View? by bindOptionalView(2)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    assertNotNull(example.present)
    assertNull(example.missing)
  }

  public fun testOptionalCached() {
    class Example(context: Context) : FrameLayout(context) {
      val present: View? by bindOptionalView(1)
      val missing: View? by bindOptionalView(2)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    assertNotNull(example.present)
    assertNull(example.missing)
    example.removeAllViews()
    example.addView(viewWithId(2))
    assertNotNull(example.present)
    assertNull(example.missing)
  }

  public fun testMissingFails() {
    class Example(context: Context) : FrameLayout(context) {
      val name : TextView? by bindView(1)
    }

    val example = Example(context)
    try {
      example.name
    } catch (e: IllegalStateException) {
      assertEquals("View ID 1 for 'name' not found.", e.message)
    }
  }

  public fun testList() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindViews(1, 2, 3)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    example.addView(viewWithId(2))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(3, example.name.count())
  }

  public fun testListCaches() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindViews(1, 2, 3)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    example.addView(viewWithId(2))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(3, example.name.count())
    example.removeAllViews()
    assertNotNull(example.name)
    assertEquals(3, example.name.count())
  }

  public fun testListMissingFails() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindViews(1, 2, 3)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    example.addView(viewWithId(3))
    try {
      example.name
    } catch (e: IllegalStateException) {
      assertEquals("View ID 2 for 'name' not found.", e.message)
    }
  }

  public fun testOptionalList() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindOptionalViews(1, 2, 3)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(2, example.name.count())
  }

  public fun testOptionalListCaches() {
    class Example(context: Context) : FrameLayout(context) {
      val name : List<TextView> by bindOptionalViews(1, 2, 3)
    }

    val example = Example(context)
    example.addView(viewWithId(1))
    example.addView(viewWithId(3))
    assertNotNull(example.name)
    assertEquals(2, example.name.count())
    example.removeAllViews()
    assertNotNull(example.name)
    assertEquals(2, example.name.count())
  }

  public fun testBind() {
    class ExampleFragment : Fragment() {
      val name : TextView by bindView(1)

      override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = FrameLayout(this@ViewTest.context)
        view.addView(textViewWithId(1))
        bind(view)
        assertNotNull(name)
        return view
      }
    }

    ExampleFragment().onCreateView(null, null, null)
  }

  private fun viewWithId(id: Int) : View {
    val view = View(context)
    view.id = id
    return view
  }

  private fun textViewWithId(id: Int) : View {
    val view = TextView(context)
    view.id = id
    return view
  }
}
