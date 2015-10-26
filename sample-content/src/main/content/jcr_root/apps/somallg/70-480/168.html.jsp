<script>
    var myApplication = myApplication || {};
    myApplication.Vehicle = function (displayControl, color, seatCount, tranType, wheelCount) {
        this.color = color;
        this.NumberOfSeats = seatCount;
        this.TransmissionType = tranType;
        this.NumberOfWheels = wheelCount;
        this.showVehicle = document.getElementById(displayControl);
    };
    
    myApplication.Vehicle.prototype = {
        Describle: function() {
            var valuesToDisplay = '';
            for (var property in this) {
                if (typeof (this[property]) === 'string') {
                    valuesToDisplay += 'Vehicle ' + property + ' is ' + this[property] + '<br/>';
                } else if(typeof (this[property]) === 'number') {
                    if (this[property] < 4) {
                        valuesToDisplay += 'Stay safe!' + '<br/>';
                    } else if (this[property] >= 10) {
                        valuesToDisplay += 'Big machine!' + '<br/>';
                    }
                }
            }
            this.showVehicle.innerHTML = valuesToDisplay;
            console.log(valuesToDisplay);
        }
    };
</script>

<div id="display"></div>
<script>
    var m = new myApplication.Vehicle('display', 'silver', 3, 'manual', 10);
    m.Describle();
</script>