var image = new ol.style.Circle({
    radius: 5,
    fill: null,
    stroke: new ol.style.Stroke({color: 'red', width: 1})
});

var styles = {
    'Point': new ol.style.Style({
        image: image
    }),
    'LineString': new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: 'green',
            width: 1
        })
    }),
    'MultiLineString': new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: 'green',
            width: 1
        })
    }),
    'MultiPoint': new ol.style.Style({
        image: image
    }),
    'MultiPolygon': new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: 'yellow',
            width: 1
        }),
        fill: new ol.style.Fill({
            color: 'rgba(255, 255, 0, 0.1)'
        })
    }),
    'Polygon': new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: 'blue',
            lineDash: [4],
            width: 3
        }),
        fill: new ol.style.Fill({
            color: 'rgba(0, 0, 255, 0.1)'
        })
    }),
    'GeometryCollection': new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: 'magenta',
            width: 2
        }),
        fill: new ol.style.Fill({
            color: 'magenta'
        }),
        image: new ol.style.Circle({
            radius: 10,
            fill: null,
            stroke: new ol.style.Stroke({
                color: 'magenta'
            })
        })
    }),
    'Circle': new ol.style.Style({
        stroke: new ol.style.Stroke({
            color: 'red',
            width: 2
        }),
        fill: new ol.style.Fill({
            color: 'rgba(255,0,0,0.2)'
        })
    })
};

var styleFunction = function(feature) {
    return styles[feature.getGeometry().getType()];
};

var geojsonObject = {};
$.ajax({
    type : 'post', //传输类型
    async : false, //同步执行
    url : 'shp', //web.xml中注册的Servlet的url-pattern
    dataType : 'json', //返回数据形式为json
    success : function(result) {
        geojsonObject = result
        var vectorSource = new ol.source.Vector({

            features: (new ol.format.GeoJSON()).readFeatures(geojsonObject,{
                featureProjection: 'EPSG:3857'
            })
        });


        var vectorLayer = new ol.layer.Vector({
            source: vectorSource,
            style: styleFunction
        });

        var map = new ol.Map({
            layers: [
                new ol.layer.Tile({
                    source: new ol.source.OSM()
                }),
                vectorLayer
            ],
            target: 'map',
            view: new ol.View({
                center: [116, 39],
                zoom: 4
            })
        });
    },
    error : function(errorMsg) {
        alert("加载数据失败");
    }
});

