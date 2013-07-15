# EncfsAnywhere
A Dropbox fileviewer with encfs-capabilities that runs entirely in your browser. It is written using GWT and compiled to a HTML/JS app that does not need any server backend.

This project only provides the gui. The filesystem module used can be found in the EncfsAnywhere-fs project.

## Use it
You find a hosted copy at <http://marcoschulte.bitbucket.org/EncfsAnywhere/EncfsAnywhere.html>

## Compatibility
### Browsers
EncfsAnywhere has been tested successfully with the following browsers

* Chrome >= 27
* Firefox >= 22

### Encfs
Encfs needs to use AES, Blowfish is not supported.

Apart from that all encfs settings should work.

## Dependencies
* EncfsAnywhere-fs (<https://bitbucket.org/marcoschulte/encfsanywhere-fs>)

## License
EncfsAnywhere is licensed under the GNU General Public License (GPL) 3.0.