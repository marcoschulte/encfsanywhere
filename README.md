# EncfsAnywhere
A Dropbox fileviewer with encfs-capabilities that runs entirely in your browser. It is using gwt and compiled to HTML/JS. This project only provides the gui. The filesystem module used can be found in EncfsAnywhere-fs.

## Compatibility
EncfsAnywhere has been tested successfully with the following browsers
* Chrome >= 27
* Firefox >= 22

Encfs needs to use AES, Blowfish is not supported. Apart from that all encfs settings should work. During my tests I've always used encfs' paranoia mode.

## Dependencies
* EncfsAnywhere-fs (See https://bitbucket.org/marcoschulte/encfsanywhere-fs)

## License
EncfsAnywhere is licensed under the GNU General Public License (GPL) 3.0