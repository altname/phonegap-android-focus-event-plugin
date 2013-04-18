/**
 * Phonegap FocusEvent plugin Copyright (c) Anton Taranovskyi <anton.taranovskyi@gmail.com>
 */

(function(cordova) {

    function FocusEventPlugin() {}

    FocusEventPlugin.prototype.focus = function( $input ) {

        var x = Math.round( $input.offset().left + $input.width()/2 );
        var y = Math.round( $input.offset().top + $input.height()/2 );

        if( document.documentElement.clientWidth != window.innerWidth ){
            x = Math.round( x*window.devicePixelRatio );
            y = Math.round( y*window.devicePixelRatio );
        }

        cordova.exec(null, null, "FocusEventPlugin", "simulateFocus", [ x, y ] );
    };

    cordova.addConstructor(function() {
        if(!window.plugins) window.plugins = {};
        window.plugins.focusEventPlugin = new FocusEventPlugin();
    });

})(window.cordova || window.Cordova);


