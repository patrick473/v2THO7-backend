# v2THO7-DEFINE

## endpoint
<table>
<tr>
    <th>veld</th>
    <th>type</th> 
    <th>omschrijving</th>
  </tr>
 <tr>
    <td></td>
    <td></td> 
    <td></td>
  </tr>
</table>


``` 
/type
```
`PUT `
<br>
paramters
<table>
<tr>
    <th>veld</th>
    <th>type</th> 
    <th>omschrijving</th>
  </tr>
 <tr>
    <td>id</td>
    <td>number</td> 
    <td>id van de businessrule type</td>
  </tr>
  <tr>
    <td>name</td>
    <td>string</td> 
    <td>naam van de businessrule type</td>
  </tr>
  <tr>
    <td>nameCode</td>
    <td>string</td> 
    <td>code van de businessrule type bv 'ARNG'</td>
  </tr>
  <tr>
    <td>explanation</td>
    <td>string</td> 
    <td>uitleg van wat de type doet</td>
  </tr>
  <tr>
    <td>example</td>
    <td>string</td> 
    <td>voorbeeld van wat de type doet</td>
  </tr>
  <tr>
    <td>constraintPossible</td>
    <td>boolean</td> 
    <td>of een constraint een optie is bij dit type</td>
  </tr>
  <tr>
    <td>possibleOperators</td>
    <td>array</td> 
    <td> alle mogelijke operators die bij deze type horen</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de operator</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;action</td>
    <td>string</td> 
    <td>wat de operator doet</td>
  </tr>
  <tr>
    <td>parameters</td>
    <td>array</td> 
    <td> alle parameters die verplicht zijn bij de rule</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;parameter</td>
    <td>string</td> 
    <td>naam van de parameter die</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;datatype</td>
    <td>string</td> 
    <td>datatype van de parameter</td>
  </tr>
  <tr>
    <td>category</td>
    <td>object</td> 
    <td> category waar de type bij hoort</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;id</td>
    <td>number</td> 
    <td>id van de category</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de category</td>
  </tr>
</table>


`POST `
<br>
parameters
<table>
<tr>
    <th>veld</th>
    <th>type</th> 
    <th>omschrijving</th>
  </tr>

  <tr>
    <td>name</td>
    <td>string</td> 
    <td>naam van de businessrule type</td>
  </tr>
  <tr>
    <td>nameCode</td>
    <td>string</td> 
    <td>code van de businessrule type bv 'ARNG'</td>
  </tr>
  <tr>
    <td>explanation</td>
    <td>string</td> 
    <td>uitleg van wat de type doet</td>
  </tr>
  <tr>
    <td>example</td>
    <td>string</td> 
    <td>voorbeeld van wat de type doet</td>
  </tr>
  <tr>
    <td>constraintPossible</td>
    <td>boolean</td> 
    <td>of een constraint een optie is bij dit type</td>
  </tr>
  <tr>
    <td>possibleOperators</td>
    <td>array</td> 
    <td> alle mogelijke operators die bij deze type horen</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de operator</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;action</td>
    <td>string</td> 
    <td>wat de operator doet</td>
  </tr>
  <tr>
    <td>parameters</td>
    <td>array</td> 
    <td> alle parameters die verplicht zijn bij de rule</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;parameter</td>
    <td>string</td> 
    <td>naam van de parameter die</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;datatype</td>
    <td>string</td> 
    <td>datatype van de parameter</td>
  </tr>
  <tr>
    <td>category</td>
    <td>object</td> 
    <td> category waar de type bij hoort</td>
  </tr>
  
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de category</td>
  </tr>
</table>


``` 
/type/all
```
`GET `
<br>
results(array)
<table>
<tr>
    <th>veld</th>
    <th>type</th> 
    <th>omschrijving</th>
  </tr>
 
 <tr>
    <td>id</td>
    <td>number</td> 
    <td>id van de businessrule type</td>
  </tr>
  <tr>
    <td>name</td>
    <td>string</td> 
    <td>naam van de businessrule type</td>
  </tr>
  <tr>
    <td>nameCode</td>
    <td>string</td> 
    <td>code van de businessrule type bv 'ARNG'</td>
  </tr>
  <tr>
    <td>explanation</td>
    <td>string</td> 
    <td>uitleg van wat de type doet</td>
  </tr>
  <tr>
    <td>example</td>
    <td>string</td> 
    <td>voorbeeld van wat de type doet</td>
  </tr>
  <tr>
    <td>constraintPossible</td>
    <td>boolean</td> 
    <td>of een constraint een optie is bij dit type</td>
  </tr>
  <tr>
    <td>possibleOperators</td>
    <td>array</td> 
    <td> alle mogelijke operators die bij deze type horen</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de operator</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;action</td>
    <td>string</td> 
    <td>wat de operator doet</td>
  </tr>
  <tr>
    <td>parameters</td>
    <td>array</td> 
    <td> alle parameters die verplicht zijn bij de rule</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;parameter</td>
    <td>string</td> 
    <td>naam van de parameter die</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;datatype</td>
    <td>string</td> 
    <td>datatype van de parameter</td>
  </tr>
  <tr>
    <td>category</td>
    <td>object</td> 
    <td> category waar de type bij hoort</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;id</td>
    <td>number</td> 
    <td>id van de category</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de category</td>
  </tr>
</table>

``` 
/type/:id
```
`GET `
<br>
results
<table>
<tr>
    <th>veld</th>
    <th>type</th> 
    <th>omschrijving</th>
  </tr>
 
 <tr>
    <td>id</td>
    <td>number</td> 
    <td>id van de businessrule type</td>
  </tr>
  <tr>
    <td>name</td>
    <td>string</td> 
    <td>naam van de businessrule type</td>
  </tr>
  <tr>
    <td>nameCode</td>
    <td>string</td> 
    <td>code van de businessrule type bv 'ARNG'</td>
  </tr>
  <tr>
    <td>explanation</td>
    <td>string</td> 
    <td>uitleg van wat de type doet</td>
  </tr>
  <tr>
    <td>example</td>
    <td>string</td> 
    <td>voorbeeld van wat de type doet</td>
  </tr>
  <tr>
    <td>constraintPossible</td>
    <td>boolean</td> 
    <td>of een constraint een optie is bij dit type</td>
  </tr>
  <tr>
    <td>possibleOperators</td>
    <td>array</td> 
    <td> alle mogelijke operators die bij deze type horen</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de operator</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;action</td>
    <td>string</td> 
    <td>wat de operator doet</td>
  </tr>
  <tr>
    <td>parameters</td>
    <td>array</td> 
    <td> alle parameters die verplicht zijn bij de rule</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;parameter</td>
    <td>string</td> 
    <td>naam van de parameter die</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;datatype</td>
    <td>string</td> 
    <td>datatype van de parameter</td>
  </tr>
  <tr>
    <td>category</td>
    <td>object</td> 
    <td> category waar de type bij hoort</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;id</td>
    <td>number</td> 
    <td>id van de category</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;name</td>
    <td>string</td> 
    <td>naam van de category</td>
  </tr>
</table>
