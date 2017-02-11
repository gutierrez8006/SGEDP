app.filter("filteri18n", ["$filter", function ($filter) {
        var filterFn = $filter("filter");

        /** Transforma el texto quitando todos los acentos diéresis, etc. **/
        function normalize(texto) {
            texto = texto.replace(/[áàäâ]/g, "a");
            texto = texto.replace(/[éèëê]/g, "e");
            texto = texto.replace(/[íìïî]/g, "i");
            texto = texto.replace(/[óòôö]/g, "o");
            texto = texto.replace(/[úùüü]/g, "u");
            texto = texto.toUpperCase();
            return texto;
        }

        /** Esta función es el comparator en el filter **/
        function comparator(actual, expected) {
            if (normalize(actual).indexOf(normalize(expected)) >= 0) {
                return true;
            } else {
                return false;
            }
        }

        /** Este es realmente el filtro **/
        function filteri18n(array, expression) {
            //Lo único que hace es llamar al filter original pero pasado
            //la nueva función de comparator
            return filterFn(array, expression, comparator);
        }

        return filteri18n;

    }]);