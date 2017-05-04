# DesafioMobile-Reto5
Mi solución del reto 5 de www.belatrixsf.com/desafio-mobile-expert/

![Interfaz gráfica de la aplicación](https://raw.githubusercontent.com/hugoangeles0810/DesafioMobile-Reto5/master/art/app.gif)

## Estructura del proyecto
- module navigationdraweractivity: Código del componente NavigationDrawerActivity
- module app: Contiene el ejemplo de la implementación de la NavigationDrawerActivity.

## Ejemplo de activity con Navigation Drawer

```java
import android.os.Bundle;
import android.support.annotation.Nullable;

import io.github.hugoangeles0810.navigationdraweractivity.NavDrawerActivityResources;
import io.github.hugoangeles0810.navigationdraweractivity.NavigationDrawerActivity;

@NavDrawerActivityResources(
        // Si bien se podrían omitir algunos párametros, esto da más flexibilidad, ya que
        // da la posibilidad de cambiar el menu y el header del drawer en cada actividad
        navigationMenu = R.menu.activity_main_drawer,
        navigationHeaderLayout = R.layout.nav_header_main,
        arrayOfMenuItemIds = R.array.menu_items_ids,
        arrayOfActivityClasses = R.array.menu_items_activities,
        currentMenuItemId = R.id.nav_second)
public class SecondActivity extends NavigationDrawerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setTitle("Second Activity");
    }
}
```

## Desarrollado Por
* Hugo Angeles  - <hugoangeles0810@gmail.com>

## Licencia

    MIT License

    Copyright (c) 2017 Hugo Angeles Chavez

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
