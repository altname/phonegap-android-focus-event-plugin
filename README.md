phonegap-android-focus-event-plugin
===================================

Plugin provides focus event to android phonegap app

1. Copy the assets/www/js/FocusEventPlugin.js file to your 'assets/www/js/' folder
2. Copy src folder to your project root folder
3. Update your res/xml/plugins.xml file with the following line:
```

   <plugin name="FocusEventPlugin" value="com.phonegap.plugin.FocusEventPlugin"/>

```

4. Add js script to your html page

```

	<script type="text/javascript" src="js/FocusEventPlugin.js"></script>

```

5. Call focus event on input or textarea you need

```

    window.plugins.focusEventPlugin.focus( [ Zepto.js object ] );

```