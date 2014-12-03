This project provides access to Android's [Palette library](https://developer.android.com/tools/support-library/features.html#v7-palette) as a service.

Usage
=====

Request
-------

Perform an HTTP GET request to ```http://palette.vinnie.io/palette?url=<photo url>```

Response
--------


    {
        "lightVibrant": "<hex color code>",  
        "lightMuted": "<hex color code>",  
        "muted": "<hex color code>",  
        "darkMuted": "<hex color code>",  
        "darkVibrant": "<hex color code>",  
        "vibrant": "<hex color code>"  
    }
    
Note: not all of these swatches may be defined. If the library couldn't find an appropriate color, then it will simply not be present in the response.


Example request
----------------

![Landscape](https://c3.staticflickr.com/3/2658/4130990745_b3182f920a_b.jpg)
Request URL: ```http://palette.vinnie.io/palette?url=https://c3.staticflickr.com/3/2658/4130990745_b3182f920a_b.jpg```

Response:

    {
        "lightVibrant": "b5c0e0",
        "lightMuted": "94a3cf",
        "muted": "6c8a9b",
        "darkMuted": "282f40",
        "darkVibrant": "694f0f",
        "vibrant": "91530d"
    }