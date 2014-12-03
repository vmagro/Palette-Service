This project provides access to Android's [Palette library](https://developer.android.com/tools/support-library/features.html#v7-palette) as a service.

Usage
=====

Request
-------

Perform an HTTP GET request to ```http://palette.vinnie.io/palette?url=<photo url>```

Response
--------


    {
        "lightVibrant": "<swatch representation>",  
        "lightMuted": "<swatch representation>",  
        "muted": "<swatch representation>",  
        "darkMuted": "<swatch representation>",  
        "darkVibrant": "<swatch representation>",  
        "vibrant": "<swatch representation>"  
    }

Swatch representation:

    {
        "red": "<red value>",
        "green": "<green value>",
        "blue": "<blue value>"
    }
    
Note: not all of these swatches may be defined. If the library couldn't find an appropriate color, then it will simply not be present in the response.


Example request
----------------

![Landscape](https://c3.staticflickr.com/3/2658/4130990745_b3182f920a_b.jpg)
Request URL: ```http://palette.vinnie.io/palette?url=https://c3.staticflickr.com/3/2658/4130990745_b3182f920a_b.jpg```

Response:

    {
        "darkVibrant": {
            "red": 105,
            "green": 79,
            "blue": 15,
            "rgb": "694f0f"
        },
        "lightMuted": {
            "red": 148,
            "green": 163,
            "blue": 207,
            "rgb": "94a3cf"
        },
        "vibrant": {
            "red": 145,
            "green": 83,
            "blue": 13,
            "rgb": "91530d"
        },
        "darkMuted": {
            "red": 40,
            "green": 47,
            "blue": 64,
            "rgb": "282f40"
        },
        "muted": {
            "red": 108,
            "green": 138,
            "blue": 155,
            "rgb": "6c8a9b"
        },
        "lightVibrant": {
            "red": 181,
            "green": 192,
            "blue": 224,
            "rgb": "b5c0e0"
        }
    }