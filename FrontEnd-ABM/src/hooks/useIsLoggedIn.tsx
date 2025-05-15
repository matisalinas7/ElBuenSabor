export default function useIsLoggedIn() {
  const token = window.localStorage.getItem('isLoggedIn');
  return Boolean(token);
}